// 789View.cpp : implementation of the CMy789View class
//

#include "stdafx.h"
#include "789.h"

#include "789Doc.h"
#include "789View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMy789View

IMPLEMENT_DYNCREATE(CMy789View, CView)

BEGIN_MESSAGE_MAP(CMy789View, CView)
	//{{AFX_MSG_MAP(CMy789View)
	ON_WM_TIMER()
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMy789View construction/destruction

CMy789View::CMy789View()
{
	// TODO: add construction code here
	m_nx=0;

}

CMy789View::~CMy789View()
{
}

BOOL CMy789View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CMy789View drawing

void CMy789View::OnDraw(CDC* pDC)
{
	CMy789Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
	SetTimer(1,100,NULL);
	pDC->TextOut (m_nx,200,"欢迎使用《Visual C++面向对象编程（第4版）》");
}

/////////////////////////////////////////////////////////////////////////////
// CMy789View printing

BOOL CMy789View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CMy789View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CMy789View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CMy789View diagnostics

#ifdef _DEBUG
void CMy789View::AssertValid() const
{
	CView::AssertValid();
}

void CMy789View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMy789Doc* CMy789View::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMy789Doc)));
	return (CMy789Doc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMy789View message handlers

void CMy789View::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	m_nx+=10;
	if(m_nx>800)
		m_nx=0;
	Invalidate();
	
	CView::OnTimer(nIDEvent);
}
