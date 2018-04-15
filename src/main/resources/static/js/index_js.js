$.when(
    $.getScript( "/node_modules/chart.js/dist/Chart.js" ),
    $.getScript( "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ),
    $.getScript( "js/MyRequestsCompleted.js"),
    $.Deferred(function( deferred ){
        $( deferred.resolve );
    })
).done(function() {

    var dataStored = [];
    var positions = [];
    $(document).ready(function () {
        var requestCallback = new MyRequestsCompleted({
            numRequest: 15,
            singleCallback: function () {
                draw();
            }
        });

        //usage in request
        searchPlayers("GK");
        searchPlayers("RB");
        searchPlayers("CB");
        searchPlayers("LB");
        searchPlayers("RWB");
        searchPlayers("LWB");
        searchPlayers("CDM");
        searchPlayers("CM");
        searchPlayers("CAM");
        searchPlayers("RM");
        searchPlayers("LM");
        searchPlayers("RW");
        searchPlayers("LW");
        searchPlayers("CF");
        searchPlayers("ST");

        function searchPlayers(position) {
            $.ajax({
                url: "/players/role/" + position,
                dataType: 'json'
            })
                .done(function (data) {
                    dataStored.push(data.length);
                    positions.push(position);
                    requestCallback.requestComplete(true);
                });
        }

        function draw() {
            console.log("Fatto");
            var ctx = document.getElementById("myChart").getContext('2d');
            var stringColors = [];
            for (var i = 0; i < 15; i++) {
                stringColors[i] = 'rgba(' + Math.floor(Math.random() * 256) + ', ' + Math.floor(Math.random() * 256) + ', ' + Math.floor(Math.random() * 256) + ', ' + 0.2 + ')';
            }

            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: positions,
                    datasets: [{
                        label: '# di giocatori',
                        data: dataStored,
                        backgroundColor: stringColors,
                        borderColor: stringColors,
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        };
    });
});