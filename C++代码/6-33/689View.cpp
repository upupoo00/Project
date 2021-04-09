// 689View.cpp : implementation of the CMy689View class
//

#include "stdafx.h"
#include "689.h"

#include "689Doc.h"
#include "689View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMy689View

IMPLEMENT_DYNCREATE(CMy689View, CView)

BEGIN_MESSAGE_MAP(CMy689View, CView)
	//{{AFX_MSG_MAP(CMy689View)
	ON_WM_LBUTTONDOWN()
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMy689View construction/destruction

CMy689View::CMy689View()
{
	// TODO: add construction code here
	m_nx=0;m_ny=0;

}

CMy689View::~CMy689View()
{
}

BOOL CMy689View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CMy689View drawing

void CMy689View::OnDraw(CDC* pDC)
{
	CMy689Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
}

/////////////////////////////////////////////////////////////////////////////
// CMy689View printing

BOOL CMy689View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CMy689View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CMy689View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CMy689View diagnostics

#ifdef _DEBUG
void CMy689View::AssertValid() const
{
	CView::AssertValid();
}

void CMy689View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMy689Doc* CMy689View::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMy689Doc)));
	return (CMy689Doc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMy689View message handlers

void CMy689View::OnLButtonDown(UINT nFlags, CPoint point) 
{
	// TODO: Add your message handler code here and/or call default
	CString str;
	str.Format ("%d:%d",point.x,point.y);
    MessageBox(str);
	
	CView::OnLButtonDown(nFlags, point);
}
