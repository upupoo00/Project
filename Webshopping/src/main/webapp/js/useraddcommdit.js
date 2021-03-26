function nextChange1()
    {
        var first = document.getElementById("first");
        var second = document.getElementById("second");
        second.options.length = 0; // 清除second下拉框的所有内容
        if(first.selectedIndex == 1)
        {
            second.options.add(new Option("手机"));
            second.options.add(new Option("电脑"));
            second.options.add(new Option("相机"));
            second.options.add(new Option("智能设备"));
            second.options.add(new Option("手机配件"));
        }

        if(first.selectedIndex == 2)
        {
            second.options.add(new Option("生活电器"));
            second.options.add(new Option("个护电器")); 
            second.options.add(new Option("生活用品"));
            second.options.add(new Option("影音娱乐"));
        }
        if(first.selectedIndex == 3)
        {
            second.options.add(new Option("女装:（上装）"));
            second.options.add(new Option("女装:（下装）"));
            second.options.add(new Option("女装:（套装）"));
            second.options.add(new Option("女装:（裙子）"));
            second.options.add(new Option("女鞋"));
            second.options.add(new Option("男装:（上装）"));
            second.options.add(new Option("男装:（下装）"));
            second.options.add(new Option("男装:（运动）"));
            second.options.add(new Option("男鞋"));
            second.options.add(new Option("袜子"));
            second.options.add(new Option("配饰"));
            second.options.add(new Option("帽子"));
        }
        if(first.selectedIndex == 4)
        {
            second.options.add(new Option("文具"));
            second.options.add(new Option("教具")); 
            second.options.add(new Option("图片"));
            second.options.add(new Option("教材"));
        }
        if(first.selectedIndex == 5)
        {
            second.options.add(new Option("手表"));
            second.options.add(new Option("眼镜")); 
            second.options.add(new Option("潮搭"));
            second.options.add(new Option("服配"));
        }

    
        //jq获取下拉框的值方法
    }