
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
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="601">bialski</option>');
                $('#powiat').append('<option value="602">biłgorajski</option>');
                $('#powiat').append('<option value="602">biłgorajski</option>');
                break;
            case '8':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="801">gorzowski</option>');
                $('#powiat').append('<option value="805">słubicki</option>');
                $('#powiat').append('<option value="862">m. Zielona Góra</option>');
                break;
            case '10':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="1001">bełchatowski</option>');
                $('#powiat').append('<option value="1010">piotrkowski</option>');
                $('#powiat').append('<option value="1061">m. Łódź</option>');
                break;
            case '12':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="1201">bocheński</option>');
                $('#powiat').append('<option value="1261">m. Kraków</option>');
                $('#powiat').append('<option value="1213">oświęcimski</option>');
                break;
            case '14':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="1408">legionowski</option>');
                $('#powiat').append('<option value="1412">miński</option>');
                $('#powiat').append('<option value="1465">m. st. Warszawa</option>');
                break;
            case '16':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="1607">nyski</option>');
                $('#powiat').append('<option value="1609">opolski</option>');
                $('#powiat').append('<option value="1661">m. Opole</option>');
                break;
            case '18':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="1807">krośnieński</option>');
                $('#powiat').append('<option value="1862">m. Przemyśl</option>');
                $('#powiat').append('<option value="1863">m. Rzeszów</option>');
                break;
            case '20':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="2001">augustowski</option>');
                $('#powiat').append('<option value="2005">hajnowski</option>');
                $('#powiat').append('<option value="2063">m. Suwałki</option>');
                break;
            case '22':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="2201">bytowski</option>');
                $('#powiat').append('<option value="2204">gdański</option>');
                $('#powiat').append('<option value="2263">m. Słupsk</option>');
                break;
            case '24':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="2471">m. Piekary Śląskie</option>');
                $('#powiat').append('<option value="2472">m. Ruda Śląska</option>');
                $('#powiat').append('<option value="2477">m. Tychy</option>');
                break;
            case '26':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="2607">ostrowiecki</option>');
                $('#powiat').append('<option value="2609">sandomierski</option>');
                $('#powiat').append('<option value="2661">m. Kielce</option>');
                break;
            case '28':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="2811">nidzicki</option>');
                $('#powiat').append('<option value="2861">m. Elbląg</option>');
                $('#powiat').append('<option value="2862">m. Olsztyn</option>');
                break;
            case '30':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="3012">krotoszyński</option>');
                $('#powiat').append('<option value="3017">ostrowski</option>');
                $('#powiat').append('<option value="3064">m. Poznań</option>');
                break;
            case '32':
                $('#powiat').append('<option value="0">---</option>');
                $('#powiat').append('<option value="3205">gryficki</option>');
                $('#powiat').append('<option value="3208">kołobrzeski</option>');
                $('#powiat').append('<option value="3261">m. Koszalin</option>');
                break;
        }



    })
});