const add = document.getElementById("add");
const fileList = document.getElementById("fileList");





let max = 5;
let count=0;
let idx=0;

fileList.addEventListener("click", function(event){
    console.log(event.target);
    let cl = event.target.classList;
    if(event.target.classList.contains("df")){
        let deleteId = event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();
        count--;
    }
})

add.addEventListener("click", function(){

    if(count>=max){
        alert("최대 5개만 가능");
        return;
    }
    count++;


    let d = document.createElement("div");
    let a = document.createAttribute("class");
    a.value="input-group mb-3";
    d.setAttributeNode(a);
    a=document.createAttribute("id");
    
    a.value="file"+idx;
    d.setAttributeNode(a);
    


    let i = document.createElement("input");
    
    a = document.createAttribute("type");
    a.value="file";
    i.setAttributeNode(a);
    
    a = document.createAttribute("class");
    a.value="form-control";
    i.setAttributeNode(a);
    
    a = document.createAttribute("id");
    a.value="photos";
    i.setAttributeNode(a);
    
    a = document.createAttribute("name");
    a.value="photos";
    i.setAttributeNode(a);
    

    d.appendChild(i);

    let s = document.createElement("span");
    let t = document.createTextNode("xxxxxx"); 
    a = document.createAttribute("class");
    a.value="df";
    s.setAttributeNode(a);
    s.appendChild(t);

    a = document.createAttribute("data-id");
    a.value="file" + idx;
    s.setAttributeNode(a);
    
    d.appendChild(s);

    fileList.appendChild(d);
    idx++;
})

