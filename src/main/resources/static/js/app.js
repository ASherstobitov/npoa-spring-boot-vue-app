
'<div id="app">'+
    '<p v-if="myImage.length > 0"><img v-bind:src="myImage"></p>' +
    '<button @click="myFunction()">Show Image</button>'+
'</div>'

'<script>'
var app = new Vue({
    el: '#app',

    data: {
        myImage:''
    },

    methods:{
        myFunction: function () {
            this.myImage = "/images/TacoCloud.png";
        }
    }

});
'</script>'