// 689View.h : interface of the CMy689View class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_689VIEW_H__8910CAF4_A65F_467C_B39B_275B300398E0__INCLUDED_)
#define AFX_689VIEW_H__8910CAF4_A65F_467C_B39B_275B300398E0__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMy689View : public CView
{
protected: // create from serialization only
	CMy689View();
	DECLARE_DYNCREATE(CMy689View)

// Attributes
public:
	CMy689Doc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy689View)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	int m_ny;
	int m_nx;
	virtual ~CMy689View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMy689View)
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in 689View.cpp
inline CMy689Doc* CMy689View::GetDocument()
   { return (CMy689Doc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_689VIEW_H__8910CAF4_A65F_467C_B39B_275B300398E0__INCLUDED_)
