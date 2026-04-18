import React, { useState, useEffect } from 'react';
import {
  Box, Typography, Grid, Paper, FormControl, Select, MenuItem,
  CircularProgress
} from '@mui/material';
import axios from 'axios';
import {
  Chart as ChartJS,
  ArcElement, Tooltip, Legend, CategoryScale, LinearScale,
  BarElement, PointElement, LineElement, Title, Filler
} from 'chart.js';
import { Pie, Bar, Line } from 'react-chartjs-2';
import './RiskAssessment.css';
import {
  USE_MOCK_DATA,
  mockDepositPieData, mockLoanPieData, mockMonthlyDepositData,
  mockMonthlyDepositVsLoanData, mockCumulativeDepositData, mockCumulativeLoanData,
  mockSegmentData, mockSchemeActivityData,
} from './mockDashboardData';

ChartJS.register(
  ArcElement, Tooltip, Legend, CategoryScale, LinearScale,
  BarElement, PointElement, LineElement, Title, Filler
);

const BASE_URL = 'https://noncbsuat.bankofbaroda.co.in/green-project/api/v1';

const COLORS = [
  '#134B2A', '#E86F25', '#1976d2', '#43a047', '#f4511e',
  '#8e24aa', '#00897b', '#fdd835', '#6d4c41', '#546e7a',
  '#d81b60', '#5c6bc0', '#26a69a', '#ff7043'
];

const currentMonth = new Date().getMonth();
const currentCalYear = new Date().getFullYear();
const defaultFY = currentMonth >= 3 ? currentCalYear : currentCalYear - 1;

const fyOptions = [];
for (let y = 2023; y <= currentCalYear + 1; y++) {
  fyOptions.push({ value: y, label: `FY ${y}-${(y + 1).toString().slice(-2)}` });
}

const chartBoxSx = {
  p: 2, borderRadius: 2, boxShadow: '0 2px 8px rgba(0,0,0,0.08)',
  background: '#fff', height: '100%', display: 'flex', flexDirection: 'column',
};

const chartTitleSx = {
  fontWeight: 700, fontSize: '1rem', color: '#134B2A', mb: 1, textAlign: 'center',
};

const RiskAssessment = () => {
  const [financialYear, setFinancialYear] = useState(defaultFY);
  const [loading, setLoading] = useState(false);
  const [depositPie, setDepositPie] = useState(null);
  const [loanPie, setLoanPie] = useState(null);
  const [monthlyDeposit, setMonthlyDeposit] = useState(null);
  const [monthlyDepositVsLoan, setMonthlyDepositVsLoan] = useState(null);
  const [cumulativeDeposit, setCumulativeDeposit] = useState(null);
  const [cumulativeLoan, setCumulativeLoan] = useState(null);
  const [loanBySegment, setLoanBySegment] = useState(null);
  const [schemeActivity, setSchemeActivity] = useState(null);

  useEffect(() => {
    fetchAllChartData(financialYear);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [financialYear]);

  const applyChartData = (depositPieRaw, loanPieRaw, monthlyDepRaw, monthlyDLRaw, cumDepRaw, cumLoanRaw, segmentRaw, schemeActRaw) => {
    if (depositPieRaw) {
      setDepositPie({
        labels: depositPieRaw.map(i => i.schemecode),
        datasets: [{ data: depositPieRaw.map(i => i.count), backgroundColor: COLORS.slice(0, depositPieRaw.length), borderWidth: 1 }],
      });
    }
    if (loanPieRaw) {
      setLoanPie({
        labels: loanPieRaw.map(i => i.accountSegment),
        datasets: [{ data: loanPieRaw.map(i => i.count), backgroundColor: COLORS.slice(0, loanPieRaw.length), borderWidth: 1 }],
      });
    }
    if (monthlyDepRaw) {
      setMonthlyDeposit({
        labels: monthlyDepRaw.map(i => `${i.month} ${i.year}`),
        datasets: [{ label: 'Deposits', data: monthlyDepRaw.map(i => i.entryCount), backgroundColor: '#134B2A', borderRadius: 4 }],
      });
    }
    if (monthlyDLRaw) {
      setMonthlyDepositVsLoan({
        labels: monthlyDLRaw.map(i => i.month),
        datasets: [
          { label: 'Deposits', data: monthlyDLRaw.map(i => i.depositsCount), backgroundColor: '#134B2A', borderRadius: 4 },
          { label: 'Loans', data: monthlyDLRaw.map(i => i.loansCount), backgroundColor: '#E86F25', borderRadius: 4 },
        ],
      });
    }
    if (cumDepRaw) {
      setCumulativeDeposit({
        labels: cumDepRaw.map(i => `${i.month} ${i.year}`),
        datasets: [{
          label: 'Cumulative Deposits', data: cumDepRaw.map(i => i.cumulativeAmount),
          borderColor: '#134B2A', backgroundColor: 'rgba(19,75,42,0.1)', fill: true, tension: 0.3, pointRadius: 4,
        }],
      });
    }
    if (cumLoanRaw) {
      setCumulativeLoan({
        labels: cumLoanRaw.map(i => `${i.month} ${i.year}`),
        datasets: [{
          label: 'Cumulative Loans', data: cumLoanRaw.map(i => i.cumulativeAmount),
          borderColor: '#E86F25', backgroundColor: 'rgba(232,111,37,0.1)', fill: true, tension: 0.3, pointRadius: 4,
        }],
      });
    }
    if (segmentRaw) {
      setLoanBySegment({
        labels: segmentRaw.map(i => i.accountSegment),
        datasets: [{ label: 'Count', data: segmentRaw.map(i => i.count), backgroundColor: COLORS.slice(0, segmentRaw.length), borderRadius: 4 }],
      });
    }
    if (schemeActRaw) {
      const schemes = [...new Set(schemeActRaw.map(i => i.schemeCode))];
      const activities = [...new Set(schemeActRaw.map(i => i.activityCode))];
      const datasets = activities.map((act, idx) => ({
        label: act,
        data: schemes.map(sc => {
          const entry = schemeActRaw.find(i => i.schemeCode === sc && i.activityCode === act);
          return entry ? entry.count : 0;
        }),
        backgroundColor: COLORS[idx % COLORS.length], borderRadius: 4,
      }));
      setSchemeActivity({ labels: schemes, datasets });
    }
  };

  const fetchAllChartData = async (fy) => {
    setLoading(true);

    // Use mock data if enabled
    if (USE_MOCK_DATA) {
      setTimeout(() => {
        applyChartData(
          mockDepositPieData, mockLoanPieData, mockMonthlyDepositData,
          mockMonthlyDepositVsLoanData, mockCumulativeDepositData, mockCumulativeLoanData,
          mockSegmentData, mockSchemeActivityData
        );
        setLoading(false);
      }, 500);
      return;
    }

    try {
      const [
        depositPieRes, loanPieRes, monthlyDepRes, monthlyDLRes,
        cumDepRes, cumLoanRes, segmentRes, schemeActRes,
      ] = await Promise.allSettled([
        axios.get(`${BASE_URL}/ViewDetailsDepositCharts/${fy}`),
        axios.get(`${BASE_URL}/ViewDetailsLoanCharts/${fy}`),
        axios.get(`${BASE_URL}/ViewDetailsDepositMonthlyChart/${fy}`),
        axios.get(`${BASE_URL}/monthly-deposit-loan-chart/${fy}`),
        axios.get(`${BASE_URL}/ViewDetailsDepositLineChart/${fy}`),
        axios.get(`${BASE_URL}/ViewDetailsLoanLineChart/${fy}`),
        axios.get(`${BASE_URL}/ViewDetailsSegmentCharts/${fy}`),
        axios.get(`${BASE_URL}/ViewDetailsSchemeActivityCharts/${fy}`),
      ]);

      const extract = (res) => res.status === 'fulfilled' ? res.value?.data : null;
      applyChartData(
        extract(depositPieRes), extract(loanPieRes), extract(monthlyDepRes),
        extract(monthlyDLRes), extract(cumDepRes), extract(cumLoanRes),
        extract(segmentRes), extract(schemeActRes)
      );
    } catch (err) {
      console.error('Error fetching chart data, falling back to mock:', err);
      applyChartData(
        mockDepositPieData, mockLoanPieData, mockMonthlyDepositData,
        mockMonthlyDepositVsLoanData, mockCumulativeDepositData, mockCumulativeLoanData,
        mockSegmentData, mockSchemeActivityData
      );
    } finally {
      setLoading(false);
    }
  };

  const pieOptions = {
    responsive: true, maintainAspectRatio: false,
    plugins: {
      legend: { position: 'right', labels: { boxWidth: 14, font: { size: 11 } } },
      tooltip: { callbacks: { label: (ctx) => `${ctx.label}: ${ctx.parsed}` } },
    },
  };

  const barOptions = {
    responsive: true, maintainAspectRatio: false,
    plugins: { legend: { display: true, position: 'top', labels: { font: { size: 11 } } } },
    scales: {
      x: { ticks: { font: { size: 10 }, maxRotation: 45 } },
      y: { beginAtZero: true, ticks: { font: { size: 10 } } },
    },
  };

  const lineOptions = {
    responsive: true, maintainAspectRatio: false,
    plugins: { legend: { display: true, position: 'top', labels: { font: { size: 11 } } } },
    scales: {
      x: { ticks: { font: { size: 10 }, maxRotation: 45 } },
      y: { beginAtZero: true, ticks: { font: { size: 10 } } },
    },
  };

  const renderChart = (title, chartData, ChartComponent, options) => (
    <Paper sx={chartBoxSx}>
      <Typography sx={chartTitleSx}>{title}</Typography>
      <Box sx={{ flex: 1, minHeight: 280, position: 'relative' }}>
        {loading ? (
          <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
            <CircularProgress size={36} sx={{ color: '#134B2A' }} />
          </Box>
        ) : chartData ? (
          <ChartComponent data={chartData} options={options} />
        ) : (
          <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100%' }}>
            <Typography color="text.secondary">No data available</Typography>
          </Box>
        )}
      </Box>
    </Paper>
  );

  return (
    <Box className="risk-assessment-charts" sx={{ p: 3, backgroundColor: '#f5f7fa', minHeight: '100vh' }}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 3 }}>
        <Typography variant="h5" sx={{ fontWeight: 800, color: '#134B2A' }}>
          Dashboard Charts
        </Typography>
        <FormControl size="small" sx={{ minWidth: 180 }}>
          <Select
            value={financialYear}
            onChange={(e) => setFinancialYear(e.target.value)}
            sx={{ backgroundColor: '#fff', fontWeight: 600, '& .MuiOutlinedInput-notchedOutline': { borderColor: '#134B2A' } }}
          >
            {fyOptions.map(fy => (
              <MenuItem key={fy.value} value={fy.value}>{fy.label}</MenuItem>
            ))}
          </Select>
        </FormControl>
      </Box>

      <Grid container spacing={3} sx={{ mb: 3 }}>
        <Grid item xs={12} md={6}>{renderChart('Deposits by Scheme Code', depositPie, Pie, pieOptions)}</Grid>
        <Grid item xs={12} md={6}>{renderChart('Loans by Account Segment', loanPie, Pie, pieOptions)}</Grid>
      </Grid>

      <Grid container spacing={3} sx={{ mb: 3 }}>
        <Grid item xs={12} md={6}>{renderChart('Monthly Deposits', monthlyDeposit, Bar, barOptions)}</Grid>
        <Grid item xs={12} md={6}>{renderChart('Monthly Deposits vs Loans', monthlyDepositVsLoan, Bar, barOptions)}</Grid>
      </Grid>

      <Grid container spacing={3} sx={{ mb: 3 }}>
        <Grid item xs={12} md={6}>{renderChart('Cumulative Deposits', cumulativeDeposit, Line, lineOptions)}</Grid>
        <Grid item xs={12} md={6}>{renderChart('Cumulative Loans', cumulativeLoan, Line, lineOptions)}</Grid>
      </Grid>

      <Grid container spacing={3} sx={{ mb: 3 }}>
        <Grid item xs={12} md={6}>{renderChart('Loans by Account Segment', loanBySegment, Bar, barOptions)}</Grid>
        <Grid item xs={12} md={6}>{renderChart('Green Loans by Scheme & Activity', schemeActivity, Bar, barOptions)}</Grid>
      </Grid>
    </Box>
  );
};

export default RiskAssessment;
