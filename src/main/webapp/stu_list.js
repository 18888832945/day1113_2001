var vm = new Vue({
    el:'#studiv',
    data:{
        list:[],
        entity:{gb:{}},
        gradelist:[],
        prolist:[],
        citylist:[],
        coulist:[],
        sids:[]
    },
    methods:{
        findAll:function () {
            var _this = this;
            var url = "/user/getStuAllList.do";
            axios.get(url).then(function (response) {
                _this.list = response.data;
            }).catch(function (error) {
                alert(error);
            })
        },
        toAddStu:function () {
            var _this = this;
            axios.get("/user/getGradeList.do").then(function (response) {
                _this.gradelist = response.data;

            }).catch(function (error) {
                console.log(error);
            });
            axios.get("/user/getCityListById.do?id=1").then(function (response) {
                _this.prolist = response.data;
            }).catch(function (error) {
                console.log(error);
            });
            document.getElementById("adddiv").style.display="block";
        },
        getCityList:function(event) {
            var id = event.target.value;
            proname = this.getCityName(this.prolist,id);
            this.entity.address = proname;
            var _this=this;
            axios.get("/user/getCityListById.do?id="+id).then(function (response) {
                _this.citylist = response.data;
                _this.coulist=[];
            }).catch(function (error) {
                console.log(error);
            });
        },
        getCouList:function (event) {
            var id = event.target.value;
            cityname = this.getCityName(this.citylist,id);
            this.entity.address=proname+cityname;
            var _this=this;
            axios.get("/user/getCityListById.do?id="+id).then(function (response) {
                _this.coulist = response.data;
            }).catch(function (error) {
                console.log(error);
            });
        },
        getCouName:function(event){
            var id = event.target.value;
            var couname = this.getCityName(this.coulist,id);
            this.entity.address=proname+cityname+couname;
        },
        saveStuInfo:function(){

            var _this = this;
            axios.post("/user/saveStuInfo.do",_this.entity).then(function (response) {
                if(response.data.flag){
                    //vue里面自身携带的刷新
                    document.getElementById("adddiv").style.display="none";
                    _this.findAll();
                }else{
                    alert(response.data.msg);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        findOne:function(sid){
            var _this = this;
            axios.get("/user/getGradeList.do").then(function (response) {
                _this.gradelist = response.data;

            }).catch(function (error) {
                console.log(error);
            });
            axios.get("/user/getCityListById.do?id=1").then(function (response) {
                _this.prolist = response.data;
            }).catch(function (error) {
                console.log(error);
            });

            axios.get("/user/findOne.do?sid="+sid).then(function (response) {
                _this.entity=response.data;
            }).catch(function (error) {
                console.log(error)
            });




            document.getElementById("adddiv").style.display="block";
        },
        deleteStudentBatch:function(){
            var _this=this;
            axios.post("/user/deleteStudentBatch.do",_this.sids).then(function (response) {
                if(response.data.flag){
                    _this.findAll();
                }else{
                    alert(response.data.msg);
                }
            }).catch(function (reason) {
                console.log(reason);
            });
        },
        getCityName:function(arr,id){
            if(arr!=null){
                for (var i = 0; i < arr.length; i++) {
                    if(arr[i].id==id){
                        return arr[i].cname;
                    }
                }
            }
        },
        /**
         * 日期格式化的
         * @param time
         * @returns {string}
         */
        dateFormat:function(time) {
            if(time!=null&&time!=''){
                //这个time是后台接收的参数，是个毫秒值，先把他变成js的时间
                var date=new Date(time);

                //date.getYear不可以用，他获取的是从1900年到现在的年份差，不能用
                var year=date.getFullYear();

                /* 在日期格式中，月份是从0开始的，因此要加  yyyy——MM-dd这的，1-9月份，前面要加一个0
                    要是月份加1
                 * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
                 * */
                var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
                var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
                var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
                var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
                var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
                // 拼接
                return year+"-"+month+"-"+day;
            }else{
                return "";
            }

        }
    }

});
vm.findAll();