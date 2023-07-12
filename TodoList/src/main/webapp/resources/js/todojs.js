const addBtn = document.getElementById("addBtn");  // Add 버튼
const deleteBtn = document.getElementById("deleteBtn"); // Delete 버튼
const inputTodo = document.getElementById("inputTodo"); // inputTodo
let count=0;

function select(){
  $.ajax({
    url : "TodoSelectAll",
    type : "POST",
    dataType : "JSON",
    success : function (todoList){
      todoListId.innerHTML="";
      $(todoList).each(function(){
        if ( this!=null){
          const li = document.createElement("li");
          li.classList.add("liContainer");  // li 생성
          
          const checkBox = document.createElement("input");
          checkBox.classList.add("check1");
          checkBox.setAttribute("type","checkbox"); // 체크박스 생성

          const span = document.createElement("span");
          span.classList.add("liSpan");  // span 생성

          const button = document.createElement("button");
          button.classList.add("liButton"); // button 생성
          button.innerText="Delete";
      
          span.innerText = this.testAddTodo;     // span의 값을 서블릿으로 얻어온 Todo값으로.
          inputTodo.value="";
          inputTodo.focus();
         
          li.append(checkBox,span,button);
          document.querySelector(".todo-list").append(li);
      
          count++;
          updateCount();



          $.ajax({
            url : "checkcheck",
            data : { "spanInput1" : span.innerText },
            type : "POST",
            success: function(result){
              if ( result == 1 ){
                checkBox.checked=true;
                span.style.textDecoration="line-through";
                span.style.color="gray";
                count--;
                updateCount();
              }

            },
            error : function(result){
              console.log(result);

            }

          });



          button.addEventListener("click",function(){    // Delete 눌렀을때 삭제  
            ///////////// DB 에서 삭제 추가 . ( delete )
            $.ajax({
              url : "deleteList",
              data : {"spanInput" : span.innerText},
              type : "POST",
              success : function(result){
                console.log("deleteList 성공");
              },
              error : function(){
                console.log("deleteList 실패")
              } 
            });
            this.parentElement.remove();
        
            if ( !checkBox.checked)
            count --;
            updateCount();
          
        });

        checkBox.addEventListener("click",function(){   // check 시 취소선
          if ( checkBox.checked ){
              span.style.textDecoration="line-through";
              span.style.color="gray";
              count--;
            $.ajax({
              url : "checkList",
              data : {"checkList" : span.innerText},
              type : "POST",
              success : function(result){             
              },
              error : function(){
              }
            })
          }else{
              span.style.textDecoration= "none";
              span.style.color="black";
              count++; 
            $.ajax({
              url : "unCheckList",
              data : {"checkList" : span.innerText},
              type : "POST",
              success : function(result){             
              },
              error : function(){
              }
            })
          } 
          updateCount();
      });
        }
      });
    },
    error : function(){
      console.log(request.status);
    }


  })
}

window.onload = select();
    

addBtn.addEventListener("click",function(){   // Add 버튼 눌렀을때 .
  
  if ( inputTodo.value=="" ) {
      alert("Todo를 써주세요 ~ ");
      inputTodo.focus();
      return false;
  }else{
        ///////////// DB 에 TodoList 추가 . ( insert )
        ///////////// DB 에 TodoList 추가 . ( insert )
        $.ajax({
          url : "addList",
          data : {"inputTodo" : inputTodo.value},
          type : "POST",
          success : function(result){
            console.log("addList 성공");
          },
          error : function(){
            console.log("addList 실패")
          }
        });
        const li = document.createElement("li");
        li.classList.add("liContainer");  // li 생성
        const checkBox = document.createElement("input");
        checkBox.classList.add("check1");
        checkBox.setAttribute("type","checkbox"); // 체크박스 생성
        const span = document.createElement("span");
        span.classList.add("liSpan");  // span 생성
        const button = document.createElement("button");
        button.classList.add("liButton"); // button 생성
        button.innerText="Delete";
        li.append(checkBox,span,button);
    
        span.innerText = inputTodo.value;   
        inputTodo.value="";
        inputTodo.focus();    
        document.querySelector(".todo-list").append(li);
    
        count++;
        updateCount();
    
        button.addEventListener("click",function(){    // Delete 눌렀을때 삭제  
          ///////////// DB 에서 삭제 추가 . ( delete )
          $.ajax({
            url : "deleteList",
            data : {"spanInput" : span.innerText},
            type : "POST",
            success : function(result){
              console.log("deleteList 성공");
            },
            error : function(){
              console.log("deleteList 실패")
            }
      
          });
          this.parentElement.remove();
      
          if ( !checkBox.checked)
          count --;
          updateCount(); 
      });  
      checkBox.addEventListener("click",function(){   // check 시 취소선
        if ( checkBox.checked ){
            span.style.textDecoration="line-through";
            span.style.color="gray";
            count--;

          $.ajax({
            url : "checkList",
            data : {"checkList" : span.innerText},
            type : "POST",
            success : function(result){             
            },
            error : function(){
            }
          })

        }else{
            span.style.textDecoration= "none";
            span.style.color="black";
            count++;

            $.ajax({
              url : "unCheckList",
              data : {"checkList" : span.innerText},
              type : "POST",
              success : function(result){             
              },
              error : function(){
              }
            })
        } 
        updateCount();
      });
  }   
  updateCount();

});






///        전체 삭제
const allDelete = document.getElementById("allDelete");
const todoListId = document.getElementById("todo-listId");
allDelete.addEventListener("click",function(){ 

    if(confirm("정말 삭제하시겠습니까?")==true){   //취소메시지가 true(ok)일때
        if(todoListId.innerHTML==''){              //목록칸이 비어있다면
            alert("삭제할 목록이 없습니다");       //삭제할 목록이 없다는 경고창뜨기
        }else{                                   //삭제할 목록이 있다면
          todoListId.innerHTML='';               //전체 삭제
            countSpanInput.innerText= "";        // 남은할일 : "" ;
            count = 0;
        }
    }else{                  //취소메시지가 false(no)일때
        return false;                   //삭제 취소
    }
      ///////////// DB 에 전체삭제 추가 . ( alldelete )
      $.ajax({
        url : "AllListDelete",
        type : "POST",
        success : function(result){
          console.log("AllListDelete 성공");
        },
        error : function(){
          console.log("AllListDelete 실패")
        }
  
      });

});
///        남은할일 표시해주는 function 
function updateCount(){
     const countSpanInput = document.getElementById("countSpanInput")
    countSpanInput.innerText = count+" 개";
    if ( count == 0 ) {
        countSpanInput.innerText="";
    }
}
///        전체목록 / 체크된목록 / 체크안된목록 보이는 버튼 .
const All = document.getElementById("All");
const Active = document.getElementById("Active");
const Complete = document.getElementById("Complete");

All.addEventListener("click", function() {
    showAll();
  });
Active.addEventListener("click", function() {
    showActive();
  });
Complete.addEventListener("click", function() {
    showComplete();
  });
  function showAll() {
    for (var i = 0; i < todoListId.children.length; i++) {
      todoListId.children[i].style.display = "flex";
    }
  }
  function showActive() {
    for (var i = 0; i < todoListId.children.length; i++) {
      
      if (todoListId.children[i].querySelector("input[type=checkbox]").checked === true) {
        todoListId.children[i].style.display = "none";
      } else {
        todoListId.children[i].style.display = "flex";
      }
    }
  }
  function showComplete() {
    for (var i = 0; i < todoListId.children.length; i++) {
      if (todoListId.children[i].querySelector("input[type=checkbox]").checked === false) {
        todoListId.children[i].style.display = "none";
      } else {
        todoListId.children[i].style.display = "flex";
      }
    }
  }

  
///        선택삭제
const checkDelete = document.getElementById("checkDelete");
checkDelete.addEventListener("click",function(){
  if (todoListId.querySelector("input[type=checkbox]:checked")){
    if ( confirm("선택 삭제하시겠습니까? ")== true){
      checkedDelete()
    }else{
      return false;
    }
  } else{
    alert("삭제목록을 체크해주세요");
  }

});
function checkedDelete(){
  const chechvalue = todoListId.querySelectorAll("input[type=checkbox]:checked");
  chechvalue.forEach(function(item){
    item.parentNode.remove();
  });
      $.ajax({
        url : "checkedDelete",
        type : "POST",
        success : function(){
        },
        error : function(){
        },
      });
}