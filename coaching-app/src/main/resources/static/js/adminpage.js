$(document).ready(
    function()
    {
        $('.edit').on('click', function()
        {
            $('#editEmployeeModal').modal('show');

            $tr = $(this).closest('tr');

            var data = $tr.children('td').map(function()
            {
                return $(this).text();
            }).get();

            console.log(data);

            $('#update_id').val(data[0]);
            $('#update_fname').val(data[1]);
            $('#update_lname').val(data[2]);
            $('#update_role').val(data[3]);
            $('#update_phonenum').val(data[4]);
        });

        $('.delete').on('click', function()
        {
            $('#deleteEmployeeModal').modal('show');

            $tr = $(this).closest('tr');

            var data = $tr.children('td').map(function()
            {
                return $(this).text();
            }).get();

            console.log(data);

            $('#delete_id').val(data[0]);
        });

        $('#search').click
        (
        function()
        {
            let search = $('#searchbar').val();
            $('#search').attr("href", $('#search').prop('href')+"?search="+search);
        });

        $('#add-email').blur
        (
            // check email if it is taken
            // it will return true if it is taken
            // true means invalid email
            function()
            {
                var email = $('#add-email');
                console.log(email.val());

                if(String(email.val())
                .toLowerCase()
                .match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) 
                {
                    var ajax = new XMLHttpRequest();
                    var method = "GET";
                    var url = "/admin/email-check?" + "email="+email.val();
                    var asynchronous = true;
                
                    ajax.open(method, url, asynchronous);
                
                    // sending ajax request
                    ajax.send();
                
                    // receiving response from url
                    ajax.onreadystatechange = function()
                    {
                        if(this.readyState == 4 && this.status == 200)
                        {
                            console.log(this.responseText);
                            if(this.responseText == "true")
                            {
                                email.val("");
                                email.attr("placeholder", "Email Taken");
                                email.addClass("invalid");
                                return;
                            }
                            email.removeClass("invalid");
                        }
                        
                    }
                }
                else
                {
                    
                    email.val("");
                    email.attr("placeholder", "Invalid Email");
                    email.addClass("invalid");
                }
            }
        );

        
    }

);
