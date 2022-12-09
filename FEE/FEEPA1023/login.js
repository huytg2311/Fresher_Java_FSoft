function checkFun() {

  var checkEmail = document.getElementById("exampleInputEmail1").value;
  if(checkEmail.length > 0){
      if (checkEmail.length > 50 || checkEmail.length < 5) {
          alert("Email length should be between 5 - 50!");
      }
  }
  else{
      alert("Email cannot be blank!");
  }

  var checkPass = document.getElementById("exampleInputPassword1").value;
  if(checkPass.length > 0 ){
      if( checkPass.length > 50 || checkEmail.length < 8){
          alert("Password length should be between 8 - 50!");
      }
  }
  else {
      alert("Password cannot be blank!");
  }

  var checkRePassword = document.getElementById("exampleInputRePassword1").value;
  if(checkRePassword.length > 0){
      if(checkRePassword.length > 50 || checkRePassword < 8){
          alert("Re Password length should be between 8 - 50!");
      }
  }
  else{
      alert("Re Password cannot be blank!");
  }


  var checkUsername = document.getElementById("exampleInputUsername1").value;
  if(checkUsername.length > 0){
      if(checkUsername.length > 30 || checkUsername.length < 3){
          alert("Username length should be between 3 - 30!");
      }
  }
  else{
      alert("Username cannot be blank!");
  }

}