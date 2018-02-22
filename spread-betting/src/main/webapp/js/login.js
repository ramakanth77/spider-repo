$(document).ready(function(){
	$("#login").click(function(){
		var name1 = $("#name").val();
		var age1 = $("#age").val();
//		Checking for blank fields.
		if( name1 =='' || age1 ==''){
			$('input[type="text"]').css("border","2px solid red");
			$('input[type="text"]').css("box-shadow","0 0 3px red");
			alert("Please fill all fields...!!!!!!");
		}else {
			alert("in else")
			$.post("save",{ name: name1, age:age1},
					function(data) {
							alert(data);
			});
		}
	});
});