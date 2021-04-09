// 123Doc.h : interface of the CMy123Doc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_123DOC_H__36F8F377_435B_4F42_9C7A_166F236BF871__INCLUDED_)
#define AFX_123DOC_H__36F8F377_435B_4F42_9C7A_166F236BF871__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMy123Doc : public CDocument
{
protected: // create from serialization only
	CMy123Doc();
	DECLARE_DYNCREATE(CMy123Doc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy123Doc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	virtual void DeleteContents();
	//}}AFX_VIRTUAL

// Implementation
public:
	int m_nflag;
	virtual ~CMy123Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMy123Doc)
	afx_msg void OnSd12();
	afx_msg void OnSd3();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_123DOC_H__36F8F377_435B_4F42_9C7A_166F236BF871__INCLUDED_)
