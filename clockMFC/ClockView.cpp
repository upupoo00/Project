// ClockView.cpp : implementation of the CClockView class
//

#include "stdafx.h"
#include "Clock.h"

#include "ClockDoc.h"
#include "ClockView.h"

#include "math.h"  //sin cos 头文件

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CClockView

IMPLEMENT_DYNCREATE(CClockView, CView)

BEGIN_MESSAGE_MAP(CClockView, CView)
	//{{AFX_MSG_MAP(CClockView)
	ON_WM_CREATE()
	ON_WM_TIMER()
	ON_WM_CANCELMODE()
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CClockView construction/destruction

CClockView::CClockView()
{
	// TODO: add construction code here

}

CClockView::~CClockView()
{
}

BOOL CClockView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CClockView drawing

void CClockView::OnDraw(CDC* pDC)
{
	CClockDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
	
	CRect rect;
	GetClientRect(&rect);//获取客户区
	//计算椭圆中心位置
	int CenterX = rect.right/2;
	int CenterY = rect.bottom/2;
	//取当前时间
	CTime Time = CTime::GetCurrentTime();
	CString strTime;
	int i,x,y;
	CSize size;
	//创建一只黄色的笔用来画椭圆
	CPen pen(PS_SOLID,5,RGB(255,255,0));
	//设置当前画笔并记下以前的画笔
	CPen *pOldPen = pDC->SelectObject(&pen);
	//绘制钟面椭圆
	pDC->Ellipse(5,5,rect.right-5,rect.bottom-5);
	double Radians;
	//设置字体颜色为红色
	pDC->SetTextColor(RGB(255,0,0));
	for (i = 1; i <= 12; ++i)
	{
		strTime.Format("%d",i);//格式化钟点值
		size = pDC->GetTextExtent(strTime,strTime.GetLength());
		Radians = (double)i*2*3.14/12.0;//2π：计算弧度
		//计算钟点放置位置
		x = CenterX - (size.cx/2) + (int)((double)(CenterX - 20) * sin(Radians));
		y = CenterY - (size.cy/2) - (int)((double)(CenterY - 20) * cos(Radians));
		//绘制钟点
		pDC->TextOut(x,y,strTime);
	}

	//计算时钟指针夹角
	Radians = (double)Time.GetHour() + (double)Time.GetMinute()/60.0 +(double)Time.GetSecond()/3600.0;
	Radians *= (2*3.14/12.0);//计算弧度
	//创建时钟画笔
	CPen HourPen(PS_SOLID,5,RGB(0,0,0));
	pDC->SelectObject(&HourPen);
	//绘制时钟指针
	pDC->MoveTo(CenterX,CenterY);
	pDC->LineTo(CenterX + (int)((double)(CenterX/3)*sin(Radians)),\
		CenterY - (int)((double)(CenterY/3)*cos(Radians)));
	/*******************************/
	//计算分钟指针夹角
	Radians = (double)Time.GetMinute() +(double)Time.GetSecond()/60.0;
	Radians *= (2*3.14/60.0);//计算弧度
	//创建分钟画笔
	CPen MinutePen(PS_SOLID,3,RGB(0,0,255));
	pDC->SelectObject(&MinutePen);
	//绘制分钟指针
	pDC->MoveTo(CenterX,CenterY);
	pDC->LineTo(CenterX + (int)((double)(CenterX*1/2)*sin(Radians)),\
		CenterY - (int)((double)(CenterY*1/2)*cos(Radians)));
	/*******************************/
	//计算秒钟指针夹角
	Radians = (double)Time.GetSecond();
	Radians *= (2*3.14/60.0);//计算弧度
	//创建秒钟画笔
	CPen SecondPen(PS_SOLID,2,RGB(255,0,0));
	pDC->SelectObject(&SecondPen);
	//绘制秒钟指针
	pDC->MoveTo(CenterX,CenterY);
	pDC->LineTo(CenterX + (int)((double)(CenterX*7/8)*sin(Radians)),\
		CenterY - (int)((double)(CenterY*7/8)*cos(Radians)));
	/*****************************/
	pDC->SelectObject(pOldPen);
}

/////////////////////////////////////////////////////////////////////////////
// CClockView printing

BOOL CClockView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CClockView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CClockView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CClockView diagnostics

#ifdef _DEBUG
void CClockView::AssertValid() const
{
	CView::AssertValid();
}

void CClockView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CClockDoc* CClockView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CClockDoc)));
	return (CClockDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CClockView message handlers

int CClockView::OnCreate(LPCREATESTRUCT lpCreateStruct) 
{
	if (CView::OnCreate(lpCreateStruct) == -1)
		return -1;
	
	// TODO: Add your specialized creation code here
	//设置定时器，1秒发送一次消息
	SetTimer(1,1000,NULL);
	
	return 0;
}

void CClockView::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	InvalidateRect(NULL,TRUE);
	UpdateWindow();
	CView::OnTimer(nIDEvent);
}

void CClockView::OnCancelMode() 
{
	CView::OnCancelMode();
	
	// TODO: Add your message handler code here
	
}
