let formData = new FormData();
let imageNum = 0;
function upload() {
    // let list = document.getElementById('upload-images').files;
    let list = $('#upload-images').prop('files');
    // 遍历上传的图片
    for (let image of list) {
        let reader = new FileReader();
        reader.readAsDataURL(image);
        reader.onload = function(e){
            let imageSrc = this.result;
            let imgStr = '<img src="'+imageSrc+'" class="upImage-image">';
            $('.upImage-span').append(imgStr);
        }
        formData.append('image'+(++imageNum) , image);
    }
}

function subBlog() {
    let title = $('#title').val();
    let content = $('#content').val();
    if (title == null || title.trim() == ''){
        alert('标题不能为空！');
        return;
    }
    if (content == null || content.trim() == ''){
        alert('博客内容不能为空！');
        return;
    }
    console.log(title);
    console.log(content);
    formData.append('title' , title);
    formData.append('content' , content);
    // console.log(formData);
    $.ajax({
        // url: 'http://localhost:8080/subBlog',
        url: 'http://121.196.145.152:8080/MyBlog/subBlog',
        data: formData,
        dataType: 'json',
        type: 'POST',
        async: false,
        cache: false,
        processData: false,
        contentType: false,
        success: function (res) {
            if (res.status == '1'){
                alert('博客发布成功！');
                // 跳转到home.jsp
                $.ajax({
                    // url: 'http://localhost:8080/requestBlog',
                    url: 'http://121.196.145.152:8080/MyBlog/requestBlog',
                    type: 'GET'
                });
                // $(window).attr('location','/requestBlog');
            }else {
                alert('博客发布失败！');
            }
            console.log(res.status);
        }
    });
}