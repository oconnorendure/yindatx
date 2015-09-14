;(function($){
// 鍥剧墖杞挱鎻掍欢
$.fn.UISlide = function(options){
var defaults = {
playTime :2000, // 闂撮殧鏃堕棿
duration :300, // 寤惰繜鏃堕棿
direction :'left', // 鏂瑰悜
easing :'easeInOutQuad', // 鑷姩鎾斁鏃� easing 鏂瑰紡
clickEasing :'easeOutCubic' // 鐐瑰嚮鏃� easing 鏂瑰紡
};
var opts = $.extend({}, defaults, options); // 鍙傛暟鍚堝苟
var slide = {
// 鎾斁璋冪敤鍙婁竴浜涘彉閲忕殑鍒濆鍖�
play: function(opts, me){
var that = this,
isPlay;
that.me = me;
that.picList = me.find('ul'); // 鍥剧墖鍒楄〃
that.title = me.find('div').find('a'); // 鍥剧墖鏍囬
that.oNum = me.find('dl'); // 鏁板瓧鎸夐挳
that.lis = that.picList.find('li'); // li
that.size = that.lis.length; // 鍥剧墖鐨勬暟閲�
that.lisWidth = that.lis.width();
that.isPlay = isPlay; // 鏄惁鑷姩鎾斁
for (var p in opts) { // opts 缁戝畾鍒� slide
that[p] = opts[p];
}
that.setNums().setTitle();
if(that.size > 1){ // 濡傛灉鍥剧墖鏁伴噺澶т簬鍒欒疆鎾�
that.autoPlay().slideEvent();
}
},
// 璁剧疆鎸夐挳
setNums: function(){
var that = this,
links, // 鍥剧墖鐨勯摼鎺�
me = that.me,
size = that.size,
oNum = that.oNum, // 鎸夐挳瀵硅薄
arrTemp = [];
links = that.picList.find('a').first();
that.title.html(links[0].title).attr('href', links[0].href); // 鎶婇摼鎺ョ殑 title 鍐呭鏀惧埌鏍囬鏍忎笂鏄剧ず
for(var i=1; i<=size; i++){
arrTemp.push('<dd>' + i + '</dd>');
}
oNum.append(arrTemp.join(''));
that.slideNum = oNum.find('dd');
that.numWidth = (that.slideNum.width() + parseInt(that.slideNum.css('margin-right')) + 2) * size + 1; // 鏁板瓧鎸夐挳瀹藉害
that.setTitle();
return that;
},
// 鑷姩鎾斁
autoPlay: function(){
var that = this,
activePos,
direction = that.direction,
picList = that.picList,
slideNum = that.slideNum,
playTime = that.playTime;
that.isPlay = setInterval(function (){
activePos = that.oNum.find('.active').index();
if(direction == 'left'){
if(activePos == (that.size - 1)){
direction = 'right';
activePos --;
} else {
activePos ++;
}
} else {
if(activePos == 0){
direction = 'left';
activePos ++;
} else {
activePos --;
}
}
picList.stop().animate({'margin-left': 0 - activePos * (that.lisWidth + 3)}, {duration: that.duration, easing: that.easing});
slideNum.removeClass('active').eq(activePos).addClass('active');
var links = picList.find('a').eq(activePos);
that.title.html(links[0].title).attr('href', links[0].href);
}, playTime);
return that;
},
// 璁剧疆鏍囬
setTitle: function(){
var that = this;
that.oNum.width(that.numWidth + 2); // 璁剧疆鏁板瓧鎸夐挳瀹藉害
that.picList.width((that.lisWidth + 3) * that.size); // 璁剧疆鍥剧墖瀹瑰櫒鎬诲搴�
that.slideNum.first().addClass('active');
return that;
},
// 缁戝畾鏁板瓧鎸夐挳浜嬩欢
slideEvent: function(){
var that = this,
slideNum = that.slideNum;
slideNum.click(function(){
var thisNum = $(this).index();
that.picList.stop().animate({"margin-left":0 - thisNum * (that.lisWidth + 3)}, {duration:that.duration, easing:that.clickEasing});
slideNum.removeClass('active').eq(thisNum).addClass('active');
var links = that.picList.find('a').eq(thisNum);
that.title.html(links[0].title).attr('href', links[0].href);
});
// 榧犳爣鍒扮敾闈腑浠绘剰浣嶇疆锛屽仠姝㈡挱鏀�
that.me.hover(function(){
clearInterval(that.isPlay);
}, function(){
that.autoPlay();
})
return that;
}
};
/*
鏈唬鐮佺敱銆愮礌鏉愬鍥�戞敹闆嗗苟缂栬緫鏁寸悊;
灏婇噸浠栦汉鍔冲姩鎴愭灉;
杞浇璇蜂繚鐣欍�愮礌鏉愬鍥�戦摼鎺� - 銆恮ww.sucaijiayuan.com銆�
*/
return this.each(function(){ // $(a,b) 鏂瑰紡璋冪敤
slide.play(opts, $(this));
});
}
})(jQuery);