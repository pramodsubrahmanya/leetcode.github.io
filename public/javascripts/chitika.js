    ( function() {
        if (window.CHITIKA === undefined) { window.CHITIKA = { 'units' : [] }; };
        var unit = {"calltype":"async[2]","publisher":"manigopal","width":728,"height":90,"sid":"Chitika Default"};
        var placement_id = window.CHITIKA.units.length;
        window.CHITIKA.units.push(unit);
        $('#adSpot').html('<div id="chitikaAdBlock-' + placement_id + '"></div>');
    }())
