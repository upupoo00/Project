// 789Doc.h : interface of the CMy789Doc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_789DOC_H__A30E7C69_0B0A_4EDB_B8DA_1888A2E899F7__INCLUDED_)
#define AFX_789DOC_H__A30E7C69_0B0A_4EDB_B8DA_1888A2E899F7__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CMy789Doc : public CDocument
{
protected: // create from serialization only
	CMy789Doc();
	DECLARE_DYNCREATE(CMy789Doc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy789Doc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CMy789Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CMy789Doc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_789DOC_H__A30E7C69_0B0A_4EDB_B8DA_1888A2E899F7__INCLUDED_)
