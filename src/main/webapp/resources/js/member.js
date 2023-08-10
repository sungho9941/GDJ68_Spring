const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name1 = document.getElementById("name");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const idx =document.getElementById("idx");
const pwx =document.getElementById("pwx");
const pwx2 =document.getElementById("pwx2");
const namex =document.getElementById("namex");
const emailx =document.getElementById("emailx");
const birthx =document.getElementById("birthx");

let idCheckResult=false;
let pwCheckResult=false;
let pw2CheckResult=false;
let nameCheckResult=false;
let emailCheckResult=false;

let checkResults=[false, false, false, false, false, false];

id.addEventListener("focusout", function(){
    fetch("../member/duplicateId?id="+id.value, {
        method:"get"
    })
    .then((response)=>{return response.text()})
    .then((r) =>{
        if(r.trim()=='1'){
            alert("중복");
        } else{
            alert("중복아님");
        }
    })
    ; 
    // 나중에 
    if(id.value.length < 1){
        document.getElementById("idx").innerHTML = "0글자 x";
        checkResults[0]=false;
    } else if(id.value.length >10){
        document.getElementById("idx").innerHTML = "10글자 초과 x";
        checkResults[0]=false;
    } else{
        

        document.getElementById("idx").innerHTML = ""; 
        checkResults[0]=true;
    }
})

pw.addEventListener("focusout", function(){
    if(pw.value.length < 6){
        document.getElementById("pwx").innerHTML = "6글자 이상";
        checkResults[1]=false;
    } else if(pw.value.length > 13){
        document.getElementById("pwx").innerHTML = "12글자 미만";
        checkResults[1]=false;
    } else{
        document.getElementById("pwx").innerHTML = "";
        checkResults[1]=true;
    }
})

pw.addEventListener("change", function(){
    pw2.value="";
    checkResults[2]=false;
    pwx2.innerHTML="?";
})

pw2.addEventListener("keyup", function(){
    if(pw.value!=pw2.value){
        document.getElementById("pwx2").innerHTML = "비밀번호 동일해야함";
        checkResults[2]=false;
    } else{
        document.getElementById("pwx2").innerHTML = "";
        checkResults[2]=true;
    }
})

name1.addEventListener("focusout", function(){
    if(name1.value.length<1){
        document.getElementById("namex").innerHTML = "아이디 입력";
        checkResults[3]=false;    
    } else{
        document.getElementById("namex").innerHTML = "";
        checkResults[3]=true;
    }
})

email.addEventListener("focusout", function(){
    if(email.value.length<1){
        document.getElementById("emailx").innerHTML = "이메일 입력";
        checkResults[4]=false;    
    } else{
        document.getElementById("emailx").innerHTML = "";
        checkResults[4]=true;
    }
})

birth.addEventListener("focusout", function(){
    if(birth.value<1){
        document.getElementById("birthx").innerHTML = "생년월일 입력";
        checkResults[5]=false;
    } else{
        document.getElementById("birthx").innerHTML = "";
        checkResults[5]=true;
    }
})


btn.addEventListener("click", function(){
    
    let c = checkResults.includes(false);
    if(!c){
        frm.submit();
    } else{
        alert("입력필수");
    }


})