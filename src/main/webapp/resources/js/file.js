const add = document.getElementById("add");
const fileList = document.getElementById("fileList");

const delets = document.getElementsByClassName("delets");
for(del of delets){
    del.addEventListener("click", function(){
        let num = this.getAttribute("data-delete-num");
        let check = confirm("ㅅㅈㅅ ㅂㄱㅂㄱ");
        if(check){
            fetch("./fileDelete?fileNum="+num, {method:"get"})
            .then((result)=>{return result.text()})
            .then((r)=>{
                if(r.trim()=='1'){
                    this.previousSibling.previousSibling.remove();
                    this.remove();
                    count--;
                }
                
            })
        }
    });
}



let max = 5;
let count=0;
if(delets !=null){
    count=delets.length;
}
let idx=0;

/*
fileList.addEventListener("click", function(event){
    console.log(event.target, "asd");
    let cl = event.target.classList;
    if(event.target.classList.contains("df")){
        let deleteId = event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();
        count--;
    }
})
*/
$("#fileList").on("click", ".df", function(){
    // let deleteId = $(this).attr("data-id")
    // $("#" + deleteId).remove();
    $(this).parent().remove();
    
    count--;
})


/*
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
*/ 

$("#add").click(function(){
    if(count>=max){
        alert("최대 5개만 가능");
        return;
    }
    count++;

    let r = '<div class="input-group mb-3" id="file' + idx + '">';
    r = r + '<input type="file" class="form-control" id="photos" name="photos">';
    r = r + '<span class="df" data-id="file' + idx+ '">XXXXXXXXXX</span>' ;
    r = r + '</div>';
    $("#fileList").append(r);
})
