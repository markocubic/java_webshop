$('document').ready(function(event){
    $('.table .btn').on('click', function(){
        event.preventDefault();
        let href = $(this).attr('href');

        $.get(href, function(user, status){
            $('#idUpdate').val(user.id);
            $('#nameUpdate').val(user.name);
            $('#emailUpdate').val(user.email);
            $('#passwordUpdate').val(user.password);
        });
    });

    $('.table #deleteButton').on('click', function(event){
        console.log("Delete!")
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#exampleModal').modal();
    });
});