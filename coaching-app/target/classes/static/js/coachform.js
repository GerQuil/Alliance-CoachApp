// const searchWrapper = document.querySelector(".inputs");
// const inputBox = document.getElementById("trainee-field");
// const suggBox = document.getElementsByClassName("autocom");
$(document).ready(
    function()
    {   
        const searchWrapper = document.querySelector(".inputs");
        const inputBox = searchWrapper.querySelector("input");
        const suggBox = searchWrapper.querySelector(".autocom");
        inputBox.onkeyup = (e)=>{
            let userData = e.target.value;
            let emptyArray = [];
            if(userData)
            {
                console.log(userData + "value");
                var ajax = new XMLHttpRequest();
                var method = "GET";
                var url = "/coach/trainees?" + "value="+userData;
                var asynchronous = true;

                ajax.open(method, url, asynchronous);

                // sending ajax request
                ajax.send();

                // receiving response from url
                ajax.onreadystatechange = function()
                {
                    if(this.readyState == 4 && this.status == 200)
                    {
                        // console.log(this.responseText);
                        let json = $.parseJSON(this.responseText);

                        json = json.map((data)=>
                        {
                            return data = {
                                "name":data.firstName + ' ' + data.lastName,
                                "email":data.email
                            }
                        });

                        for(let i = 0; i<json.length; i++)
                        {
                            console.log(json[i]);
                        }

                        emptyArray = json.map((data)=>{
                            return data = '<li>'+ data.name +' (<em>'+data.email+'</em>)'+'</li>';
                        });
                        console.log(emptyArray);
                        searchWrapper.classList.add("active");
                        showSuggestions(emptyArray);
                        let allList = suggBox.querySelectorAll("li");
                        for(let i = 0; i < allList.length; i++){
                            allList[i].setAttribute("onclick","select(this)");
                        }
                    }else{
                        searchWrapper.classList.remove("active");
                    }

                    
                            
                    }
                    
                }
                
            }

        // function select(element){
        //     let selectUserData = element.textContext;
        //     console.log(selectUserData);
        //     inputBox.value = selectUserData;
        // }        

        function showSuggestions(list){
            let listData;
            if(!list.length){
                userValue = inputBox.value;
                listData = '<li>'+ userValue +'</li>';
            }else{
                listData = list.join('');
            }
            suggBox.innerHTML = listData;
        }

        var today = new Date();
        var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        var dateTime = date+' '+time;
        document.getElementById("date").value = dateTime;
    }
);
function select(element){
    let selectUserData = element.textContent;
    let userEmail = element.firstElementChild.textContent;
    console.log(selectUserData);
    console.log(userEmail);
    document.getElementById("trainee-field").value = selectUserData;
    document.getElementById("trainee-email").value = userEmail;
    let inputname = document.getElementsByTagName("li");
    for (let i = 0; i < inputname.length; i++) {
        inputname[i].style.display = "none";
      }
}

function getData(value)
{
 
    // the id of the textfield
   
             
}

