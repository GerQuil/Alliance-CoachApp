$(document).ready(
    function()
    {
        // jquery id of the textfield
        $('#trainee-field').keypress
        (
            function()
            {
                // the id of the textfield
                var value = $('#trainee-field');
                console.log(value.val());

                var ajax = new XMLHttpRequest();
                var method = "GET";
                var url = "/coach/trainees?" + "value="+value.val();
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
                        var json = $.parseJSON(this.responseText);

                        for(i = 0; i<json.length; i++)
                        {
                            console.log(json[i].id);
                        }
                    }
                    
                }
                
            }
        );
    }
);
