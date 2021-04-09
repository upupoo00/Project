// 689Doc.cpp : implementation of the CMy689Doc class
//

#include "stdafx.h"
#include "689.h"

#include "689Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMy689Doc

IMPLEMENT_DYNCREATE(CMy689Doc, CDocument)

BEGIN_MESSAGE_MAP(CMy689Doc, CDocument)
	//{{AFX_MSG_MAP(CMy689Doc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMy689Doc construction/destruction

CMy689Doc::CMy689Doc()
{
	// TODO: add one-time construction code here

}

CMy689Doc::~CMy689Doc()
{
}

BOOL CMy689Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CMy689Doc serialization

void CMy689Doc::Serialize(CArchive& ar)
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
// CMy689Doc diagnostics

#ifdef _DEBUG
void CMy689Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CMy689Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMy689Doc commands
