package com.bob.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface BarChartDailyDTO {
   
	
    String getEntryDate();
    double getEntryCount();
}
