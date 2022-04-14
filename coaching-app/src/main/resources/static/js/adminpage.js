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

            $('#update_id').val(data[1]);
            $('#update_fname').val(data[2]);
            $('#update_lname').val(data[3]);
            $('#update_role').val(data[4]);
            $('#update_phonenum').val(data[5]);
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

            $('#delete_id').val(data[1]);
        });

        $('#search').click
        (
        function()
        {
            let search = $('#searchbar').val();
            $('#search').attr("href", $('#search').prop('href')+"?search="+search);
        });
    }

);



