// 689Doc.h : interface of the CMy689Doc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_689DOC_H__BCE29BEE_1AF5_4716_9B5D_D55741714F28__INCLUDED_)
#define AFX_689DOC_H__BCE29BEE_1AF5_4716_9B5D_D55741714F28__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMy689Doc : public CDocument
{
protected: // create from serialization only
	CMy689Doc();
	DECLARE_DYNCREATE(CMy689Doc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy689Doc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CMy689Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMy689Doc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_689DOC_H__BCE29BEE_1AF5_4716_9B5D_D55741714F28__INCLUDED_)
