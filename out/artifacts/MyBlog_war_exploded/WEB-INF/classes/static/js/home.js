$(document).ready(function(){

    $('button').click(function () {
        let myDate = new Date;
        let curTime = myDate.getFullYear() + '-'
            + (myDate.getMonth() + 1) + '-'
            + myDate.getDate() + ' '
            + myDate.getHours() + ':'
            + myDate.getMinutes() + ':'
            + myDate.getSeconds();
        let list = $('.sure-btn');
        let index = list.index(this);
        let plDiv = $('.pl-div2').eq(index);
        let plDivHtml = plDiv.html();
        let strP = $('.pl-input').eq(index);
        let val = strP.val();
        if (val == null || val.trim() == ''){
            alert('评论不能为空！');
            return;
        }
        let myName = $('.my-name').text();
        plDiv.html('<p><label class="dis-name">'+curTime+' '+myName+'：</label>'+val+'</p>'+plDivHtml);
        strP.val('');
        console.log('<p><label class="dis-name">'+curTime+' '+myName+'：</label>'+val+'</p>'+plDivHtml);

        // 提交此条评论
        let blogId = $('.blog-id').eq(index).text();
        let discusser = $('.my-userId').text();
        let content = val;
        console.log('blogId: ' + blogId + 'discusser: ' + discusser + 'content: ' + content);
        // if (blogId != null && blogId.trim() != '' && ){
        // }
        $.ajax({
            // url: 'http://localhost:8080/subDiscuss',
            url: 'http://121.196.145.152:8080/MyBlog/subDiscuss',
            data: 'blogId=' + blogId + '&discusser=' + discusser + '&content=' + content,
            type: 'POST',
            cache: false,
            success: function (res) {
                console.log(res.status);
            }
        });

    });

    $('.good-span').click(function () {
        let list = $('.good-span');
        let index = list.index(this);
        let lable = $('.good-num').eq(index);
        let num = parseInt(lable.text());
        lable.text(num+1);
        console.log(list.length);
        console.log('索引是 '+index);
        console.log(parseInt(num));

        // 提交点赞
        console.log('.blog-id 的数量：' + $('.blog-id').length);
        let blogId = $('.blog-id').eq(index).text();
        if (blogId == null || blogId.trim() == ''){
            console.log('blogId: ' + blogId);
        }
        $.ajax({
            // url: 'http://localhost:8080/subGoodNum',
            url: 'http://121.196.145.152:8080/MyBlog/subGoodNum',
            data: 'blogId=' + blogId,
            type: 'POST',
            cache: false,
            success: function (res) {
                console.log(res.status);
            }
        });
    });
})
