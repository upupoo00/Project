// 689.h : main header file for the 689 application
//

#if !defined(AFX_689_H__5AD93BA1_5EE6_4DF6_BEB0_585A88334965__INCLUDED_)
#define AFX_689_H__5AD93BA1_5EE6_4DF6_BEB0_585A88334965__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CMy689App:
// See 689.cpp for the implementation of this class
//

class CMy689App : public CWinApp
{
public:
	CMy689App();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CMy689App)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CMy689App)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_689_H__5AD93BA1_5EE6_4DF6_BEB0_585A88334965__INCLUDED_)
