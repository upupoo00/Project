// 789Doc.cpp : implementation of the CMy789Doc class
//

#include "stdafx.h"
#include "789.h"

#include "789Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMy789Doc

IMPLEMENT_DYNCREATE(CMy789Doc, CDocument)

BEGIN_MESSAGE_MAP(CMy789Doc, CDocument)
	//{{AFX_MSG_MAP(CMy789Doc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMy789Doc construction/destruction

CMy789Doc::CMy789Doc()
{
	// TODO: add one-time construction code here

}

CMy789Doc::~CMy789Doc()
{
}

BOOL CMy789Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CMy789Doc serialization

void CMy789Doc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CMy789Doc diagnostics

#ifdef _DEBUG
void CMy789Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CMy789Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMy789Doc commands
