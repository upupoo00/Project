// 789View.h : interface of the CMy789View class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_789VIEW_H__413F6A67_F3D4_4434_8637_78B14F8481DA__INCLUDED_)
#define AFX_789VIEW_H__413F6A67_F3D4_4434_8637_78B14F8481DA__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMy789View : public CView
{
protected: // create from serialization only
	CMy789View();
	DECLARE_DYNCREATE(CMy789View)

// Attributes
public:
	CMy789Doc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy789View)
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
	int m_nx;
	virtual ~CMy789View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMy789View)
	afx_msg void OnTimer(UINT nIDEvent);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in 789View.cpp
inline CMy789Doc* CMy789View::GetDocument()
   { return (CMy789Doc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_789VIEW_H__413F6A67_F3D4_4434_8637_78B14F8481DA__INCLUDED_)
