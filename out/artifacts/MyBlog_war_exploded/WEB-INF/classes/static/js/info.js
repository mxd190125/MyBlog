function preView() {
    let reads = new FileReader();
    let f = document.getElementById('myfile').files[0];
    reads.readAsDataURL(f);
    reads.onload = function(e) {
        document.getElementById('preViewImg').src = this.result;
    };
}

function subPhoto() {
    let formData = new FormData();
    let file = $('#myfile')[0].files[0];
    if (file == null){
        alert('请先上传头像！');
        return;
    }
    formData.append('photo', file);  //添加图片信息的参数
    $.ajax({
        // url: 'http://localhost:8080/upHeadPhoto',
        url: 'http://121.196.145.152:8080/MyBlog/upHeadPhoto',
        data: formData,
        dataType: 'json',
        type: 'POST',
        cache: false,
        contentType: false,
        processData: false,
        success: function (res) {
            if (res.status == '1'){
                alert('头像上传成功！');
            }else {
                alert('头像上传失败！');
            }
            console.log(res.status);
        }
    });
}

function modify() {
    let password = $('#password').val().trim();
    if (password == null || password.length == 0){
        alert('密码不能为空！');
        return;
    }
    $.ajax({
        // url: 'http://localhost:8080/modifyPassword',
        url: 'http://121.196.145.152:8080/MyBlog/modifyPassword',
        data: 'password=' + password,
        dataType: 'json',
        type: 'POST',
        success: function (res) {
            if (res.status == '1'){
                alert('密码修改成功！');
            }else {
                alert('密码修改失败！');
            }
            console.log(res.status);
        }
    });
}