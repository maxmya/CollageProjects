// notification of booking at yacout offers


var dataRef = firebase.database().ref('offers/');

var flag = false;

dataRef.once('value').then(function (snapShoot) {


    snapShoot.forEach(function (datum) {

        keys = datum.key;

        var newdataRef = firebase.database().ref('offers/' + keys + '/users');

        newdataRef.on('child_added', function (dataSnap) {

            if (flag) {

                var datum = dataSnap.val();
                var user = dataSnap.key;

                var userDataRef = firebase.database().ref('users/' + user);
                userDataRef.once('value').then(function (data) {

                    var offerRef = firebase.database().ref('offers/' + newdataRef.parent.key);

                    offerRef.once('value').then(function (dataaa) {

                        var offerDatum = dataaa.val();
                        var offerName = offerDatum.title;

                        var userDatum = data.val();
                        var userName = userDatum.name;
                        Notify(userName + " booked at " + offerName);
                    })


                })

            }


        })


    })

    flag = true;

})


