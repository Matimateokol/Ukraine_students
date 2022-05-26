
$(document).ready(function(){
    $('#wojewodztwo').bind('change', function(){

        $('#powiat option').remove();

        switch($(this).val()) {
            case '2':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="201">bolesławiecki</option>');
                $('#powiat').append('<option value="202">dzierżoniowski</option>');
                $('#powiat').append('<option value="203">głogowski</option>');
                $('#powiat').append('<option value="204">górowski</option>');
                break;
            case '4':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="401">aleksandrowski</option>');
                $('#powiat').append('<option value="402">brodnicki</option>');
                break;
            case '6':
                $('#powiat').append('<option value="0">000</option>');
                $('#powiat').append('<option value="601">bialski</option>');
                $('#powiat').append('<option value="602">biłgorajski</option>');
                break;
        }



    })
});
