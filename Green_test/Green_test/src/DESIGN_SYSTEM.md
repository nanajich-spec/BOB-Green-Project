# Green Finance Portal - Design System & Style Guide

## Overview
This document outlines the improved design system for the Green Finance Portal, ensuring consistent, modern, and accessible UI/UX across all pages.

## Design Principles

### 1. **Responsive Design**
- Mobile-first approach
- Flexible layouts that adapt to all screen sizes
- Proper spacing and padding at all breakpoints
- Readable typography on all devices

### 2. **Visual Hierarchy**
- Clear typography hierarchy (h1 → h6)
- Consistent use of color and spacing
- Strategic use of shadows for depth
- Proper contrast ratios for accessibility

### 3. **Consistency**
- Unified color palette
- Standardized spacing (8px base unit)
- Consistent border-radius and shadows
- Reusable component styles

### 4. **Accessibility**
- WCAG AA compliance (minimum)
- Keyboard navigation support
- Focus visible states on all interactive elements
- Sufficient color contrast

---

## Color Palette

### Primary Brand Colors
- **Primary Green**: `#166534` - Main brand color
- **Secondary Green**: `#22c55e` - Accent and highlights
- **Tertiary Green**: `#ecfdf3` - Light background
- **Muted Green**: `#f0fdf4` - Very light background

### Secondary Colors
- **Blue**: `#0284c7` - Alternative color for some sections
- **Neutral**: `#0f172a` - Dark text
- **Gray**: `#475569` - Secondary text

### Semantic Colors
- **Success**: `#16a34a` - Green (success states)
- **Error**: `#dc2626` - Red (error states)
- **Warning**: `#ea580c` - Orange (warning states)
- **Info**: `#0284c7` - Blue (info states)

### Background Colors
- **Page Background**: `#f3f7f4` - Light green
- **Surface**: `#ffffff` - White (cards, tables, forms)
- **Surface Secondary**: `#f8fafb` - Very light gray

---

## Typography

### Font Family
Primary: `'Segoe UI', -apple-system, BlinkMacSystemFont, 'Roboto', sans-serif`

### Font Sizes
- `h1`: 2rem (32px) | weight: 700 | letter-spacing: -0.5px
- `h2`: 1.5rem (24px) | weight: 600 | letter-spacing: -0.3px
- `h3`: 1.2rem (19px) | weight: 600
- `h4`: 1.05rem (17px) | weight: 600
- `body`: 0.95rem (15px) | weight: 400 | line-height: 1.6
- `small`: 0.85rem (14px) | weight: 400
- `xs`: 0.75rem (12px) | weight: 500

### Letter Spacing
- Headers: -0.3px to -0.5px (tight for impact)
- Body text: 0.3px (readable)
- UI elements: 0.2px-0.3px

### Line Height
- Headers: 1.2
- Body text: 1.6
- Form labels: 1.4

---

## Spacing System

Base unit: **8px**

- `--spacing-xs`: 4px
- `--spacing-sm`: 8px
- `--spacing-md`: 12px
- `--spacing-lg`: 16px
- `--spacing-xl`: 20px
- `--spacing-2xl`: 24px
- `--spacing-3xl`: 32px

**Usage:**
- Page padding: `24px` (3 units)
- Section padding: `24px` (3 units)
- Component padding: `16px` (2 units)
- Gap between elements: `12-16px` (1.5-2 units)

---

## Border Radius

- `--radius-sm`: 6px - Small elements (badges, small buttons)
- `--radius-md`: 12px - Standard (inputs, tables, cards)
- `--radius-lg`: 16px - Large components (modals, panels)
- `rounded-full`: 9999px - Circles and badges

---

## Shadows

### Shadow Levels
```css
--shadow-xs: 0 1px 2px rgba(15, 23, 42, 0.05);      /* Subtle */
--shadow-sm: 0 2px 8px rgba(15, 23, 42, 0.08);      /* Light */
--shadow-soft: 0 4px 12px rgba(15, 23, 42, 0.08);  /* Standard */
--shadow-lg: 0 10px 24px rgba(15, 23, 42, 0.12);   /* Emphasis */
```

**Usage:**
- Cards & Panels: `shadow-soft`
- Hover states: `shadow-lg`
- Floating elements: `shadow-lg`
- Subtly interactive: `shadow-sm`

---

## Components

### Tables

**Features:**
- Gradient headers (green to light green)
- Alternating row colors (white & light gray)
- Hover effects with subtle background change
- Responsive pagination with clear styling
- Proper spacing in cells (14px padding)

**Key Classes:**
```css
.data-table-container    /* Main wrapper */
.p-datatable-thead > tr > th  /* Headers */
.p-datatable-tbody > tr > td  /* Cells */
.p-paginator             /* Pagination */
```

### Forms

**Input Fields:**
- Consistent padding: `10px 12px`
- Border: `1px solid #cbd5e1`
- Border-radius: `8px`
- Focus state: Green border + light background
- Error state: Red border + light red background

**Labels:**
- Font-weight: `600`
- Font-size: `0.95rem`
- Required marker: Red asterisk `*`

**Buttons:**
- Primary: Green gradient background
- Secondary: Light gray background
- Padding: `12px 24px`
- Text-transform: `uppercase`
- Letter-spacing: `0.3px`
- Min-height: `44px` (accessibility)

### Cards & Panels
- White background (`#ffffff`)
- Border: `1px solid #e5e7eb`
- Border-radius: `12px`
- Shadow: `shadow-soft`
- Padding: `24px`

---

## Responsive Breakpoints

### Mobile First Approach

**Small (< 576px)**
- Single column layouts
- Reduced padding: `12px`
- Smaller font sizes
- Stacked navigation/buttons

**Medium (576px - 768px)**
- 2-column grids
- Standard padding: `16px`
- Simple tables collapse gracefully

**Large (768px+)**
- Multi-column layouts
- Full padding: `24px`
- Full-featured tables
- Side-by-side content

**Extra Large (1200px+)**
- Max-width containers
- Expanded layouts
- Full feature set

---

## Layout Structure

### App Shell
```
┌─────────────────────────────────────┐
│         Header (76px)               │
├─────────────────────────────────────┤
│ │                                   │
│S│  Main Content Area                │
│i│  (Flexible, with padding)         │
│d│                                   │
│e│  • Dynamic margin-left based on   │
│b│    sidebar state                  │
│a│  • Responsive on mobile           │
│r│  • Min-height accounts for footer │
│ │                                   │
├─────────────────────────────────────┤
│         Footer                      │
└─────────────────────────────────────┘
```

### Main Content Area
- `padding: 24px` (desktop) / `16px` (mobile)
- `background-color: #f3f7f4`
- `margin-left: 0-260px` based on sidebar
- Smooth transitions for sidebar collapse

---

## Accessibility Standards

### Keyboard Navigation
- All interactive elements are keyboard accessible
- Tab order follows visual flow
- Focus indicators are visible (green outline)

### Color Contrast
- WCAG AA: 4.5:1 for text
- WCAG AAA: 7:1 for important elements
- Don't rely on color alone for information

### Focus States
```css
:focus-visible {
  outline: 3px solid #166534;
  outline-offset: 2px;
}
```

### Screen Readers
- Semantic HTML
- Proper ARIA labels where needed
- Alt text for images
- Form labels associated with inputs

### Motion
- Respects `prefers-reduced-motion`
- Animations transition: 0.01ms when reduced motion enabled

---

## Animation & Transitions

### Standard Transitions
```css
transition: all 0.2s ease;
```

### Colors & Borders
```css
transition: border-color 0.2s ease, box-shadow 0.2s ease;
```

### Transform (Hover Effects)
```css
transition: transform 0.2s ease, box-shadow 0.2s ease;
```

### Duration Guidelines
- Quick interactions: 0.2s (input focus, color changes)
- Medium interactions: 0.3s (hover states, subtle changes)
- Slow transitions: 0.5s+ (layout changes, slide-ins)

---

## File Structure

```
src/
├── App.css                 /* Global app styles */
├── index.css              /* Base styles, imports design system */
├── styles/
│   ├── TableStyles.css    /* All table component styles */
│   ├── FormStyles.css     /* Form component styles */
│   └── ResponsiveUtils.css /* Utility classes */
├── Header.js / Header.css
├── Sidebar.js / Sidebar.css
├── DataTable.js / DataTable.css
├── Maker.js / Maker.css
├── Checker.js / Checker.css
├── Admin.js / Admin.css
└── [other components]
```

---

## Implementation Checklist

- [x] Fixed overlapping content issue with responsive margins
- [x] Implemented consistent table styling across all pages
- [x] Created comprehensive form styling guide
- [x] Added responsive utility classes
- [x] Improved typography hierarchy
- [x] Enhanced color palette and contrast
- [x] Added proper spacing/padding system
- [x] Implemented smooth transitions and hover effects
- [x] ensured WCAG AA accessibility compliance
- [x] Mobile-first responsive design
- [x] Proper z-index management
- [x] Consistent shadow elevation system

---

## Common Usage Examples

### Create a Data Table
```html
<div class="data-table-container">
  <div class="p-datatable-wrapper">
    <!-- PrimeReact DataTable component -->
  </div>
</div>
```

### Create a Form
```html
<form class="form-container">
  <div class="form-section">
    <h3 class="form-section-title">User Information</h3>
    <div class="form-row">
      <div class="form-group">
        <label class="form-label required">Name</label>
        <input type="text" class="form-input" />
      </div>
      <div class="form-group">
        <label class="form-label required">Email</label>
        <input type="email" class="form-input" />
      </div>
    </div>
  </div>
</form>
```

### Create a Card
```html
<div class="form-container" style="max-width: 600px;">
  <!-- Card content -->
</div>
```

---

## Future Enhancements

1. **Dark Mode Support** - CSS variables prepared for dark theme
2. **Component Library** - Extract reusable React components
3. **Storybook Integration** - Document component variations
4. **Performance** - CSS modules or Tailwind for better tree-shaking
5. **Animation Library** - Consider Framer Motion for complex animations
