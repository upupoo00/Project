// 123View.h : interface of the CMy123View class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_123VIEW_H__A17C13B1_C74F_436E_815E_FE6358551A8C__INCLUDED_)
#define AFX_123VIEW_H__A17C13B1_C74F_436E_815E_FE6358551A8C__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMy123View : public CView
{
protected: // create from serialization only
	CMy123View();
	DECLARE_DYNCREATE(CMy123View)

// Attributes
public:
	CMy123Doc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy123View)
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
	virtual ~CMy123View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMy123View)
	afx_msg void OnUpdateSd3(CCmdUI* pCmdUI);
	afx_msg void OnUpdateSd12(CCmdUI* pCmdUI);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in 123View.cpp
inline CMy123Doc* CMy123View::GetDocument()
   { return (CMy123Doc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_123VIEW_H__A17C13B1_C74F_436E_815E_FE6358551A8C__INCLUDED_)
