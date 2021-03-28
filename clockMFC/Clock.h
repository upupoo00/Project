// Clock.h : main header file for the CLOCK application
//

#if !defined(AFX_CLOCK_H__D630D3A0_2DA7_4FD5_BFC1_38C9319C6028__INCLUDED_)
#define AFX_CLOCK_H__D630D3A0_2DA7_4FD5_BFC1_38C9319C6028__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CClockApp:
// See Clock.cpp for the implementation of this class
//

class CClockApp : public CWinApp
{
public:
	CClockApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CClockApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CClockApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CLOCK_H__D630D3A0_2DA7_4FD5_BFC1_38C9319C6028__INCLUDED_)
