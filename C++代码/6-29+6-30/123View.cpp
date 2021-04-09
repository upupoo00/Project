// 123View.cpp : implementation of the CMy123View class
//

#include "stdafx.h"
#include "123.h"

#include "123Doc.h"
#include "123View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMy123View

IMPLEMENT_DYNCREATE(CMy123View, CView)

BEGIN_MESSAGE_MAP(CMy123View, CView)
	//{{AFX_MSG_MAP(CMy123View)
	ON_UPDATE_COMMAND_UI(ID_SD_3, OnUpdateSd3)
	ON_UPDATE_COMMAND_UI(ID_SD_12, OnUpdateSd12)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMy123View construction/destruction

CMy123View::CMy123View()
{
	// TODO: add construction code here

}

CMy123View::~CMy123View()
{
}

BOOL CMy123View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CMy123View drawing

void CMy123View::OnDraw(CDC* pDC)
{
	CMy123Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
	switch(pDoc->m_nflag)
	{
	case 0: pDC->TextOut (100,100,"Êä³ö×Ö·û´®");
		break;
	case 1: pDC->Ellipse (200,200,300,300);
	}
}

/////////////////////////////////////////////////////////////////////////////
// CMy123View printing

BOOL CMy123View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CMy123View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CMy123View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CMy123View diagnostics

#ifdef _DEBUG
void CMy123View::AssertValid() const
{
	CView::AssertValid();
}

void CMy123View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMy123Doc* CMy123View::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMy123Doc)));
	return (CMy123Doc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMy123View message handlers

void CMy123View::OnUpdateSd3(CCmdUI* pCmdUI) 
{
	// TODO: Add your command update UI handler code here
	CMy123Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if(pDoc->m_nflag !=0)
      pCmdUI->Enable (FALSE);
	else
      pCmdUI->Enable (TRUE);
	
}

void CMy123View::OnUpdateSd12(CCmdUI* pCmdUI) 
{
	// TODO: Add your command update UI handler code here
	CMy123Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if(pDoc->m_nflag !=1)
      pCmdUI->Enable (FALSE);
	else
      pCmdUI->Enable (TRUE);
}
