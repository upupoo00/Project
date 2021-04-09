// 123Doc.cpp : implementation of the CMy123Doc class
//

#include "stdafx.h"
#include "123.h"

#include "123Doc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CMy123Doc

IMPLEMENT_DYNCREATE(CMy123Doc, CDocument)

BEGIN_MESSAGE_MAP(CMy123Doc, CDocument)
	//{{AFX_MSG_MAP(CMy123Doc)
	ON_COMMAND(ID_SD_12, OnSd12)
	ON_COMMAND(ID_SD_3, OnSd3)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CMy123Doc construction/destruction

CMy123Doc::CMy123Doc()
{
	// TODO: add one-time construction code here

}

CMy123Doc::~CMy123Doc()
{
}

BOOL CMy123Doc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CMy123Doc serialization

void CMy123Doc::Serialize(CArchive& ar)
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
// CMy123Doc diagnostics

#ifdef _DEBUG
void CMy123Doc::AssertValid() const
{
	CDocument::AssertValid();
}

void CMy123Doc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CMy123Doc commands

void CMy123Doc::DeleteContents() 
{
	// TODO: Add your specialized code here and/or call the base class
	m_nflag=0;
	
	CDocument::DeleteContents();
}

void CMy123Doc::OnSd12() 
{
	// TODO: Add your command handler code here
	m_nflag=0;
	UpdateAllViews(NULL);
	
}

void CMy123Doc::OnSd3() 
{
	// TODO: Add your command handler code here
	m_nflag=1;
   	UpdateAllViews(NULL);
	
}
