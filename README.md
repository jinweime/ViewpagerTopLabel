# labelpager

#注意几个地方
```Java
//添加TITLES到VIEW上面
toptitlepage.addTitle(titles);
//默认显示第0个
toptitlepage.topTitColorMove(0);
//点击VIEW滑动PAGER
toptitlepage.setOnTabLinstener(new LabelPager.onTabLinstener() {
            @Override
            public void onItemClick(int index) {
                viewPager.setCurrentItem(index);
            }
        });
```
