var vm = new Vue({
    el:"#vuediv",
    methods:{
        fileupload:function () {
            var formData = new window.FormData();
            formData.append('file', document.querySelector('input[type=file]').files[0]);
            var options = {
                url: '/teacher/fileUpload.do',
                data: formData,
                method: 'post',
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            };
            var _this = this;
            axios(options).then(function (response) {
                alert(response.data.msg);
            });
        }
    }
});