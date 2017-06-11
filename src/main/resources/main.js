
let personIdentity = Vue.component('person-identity', {

    data: function() {
        return {
            allUsers:[]
            // identity: {
            //     id: "id1",
            //     userName: "Nejib",
            //     email: "Nejib@email.com"
            // },
            // identity2: {
            //     id: "id1",
            //     userName: "Me7rez",
            //     email: "Me7rez@email.com"
            // },
            // identity3: {
            //     id: "id1",
            //     userName: "Dhawi",
            //     email: "Dhawi@email.com"
            // },
            // identity4: {
            //     id: "id1",
            //     userName: "Toukebri",
            //     email: "Toukebri@email.com"
            // },
            // identity5: {
            //     id: "id1",
            //     userName: "Mouldi",
            //     email: "Mouldi@email.com"
            // },
            // fullAddress: {
            //     address: "9 rue Victor Marquiny 94250",
            //     city: "Gentilly",
            //     country: "France"
            // },
            // fullAddress2: {
            //     address: "Paris Paris Paris",
            //     city: "Paris",
            //     country: "France"
            // },
            // fullAddress4: {
            //     address: "Juvisy 3ala orge",
            //     city: "Juvisy",
            //     country: "France"
            // }
        }
    },

    template: `

    <table class="table">
         <thead class="thead-inverse">
            <tr>
              <th>#</th>
              <th>Username</th>
              <th>Email</th>
              <th>Address</th>
              <th>City</th>
              <th>Country</th>
            </tr>
         </thead>
  <tbody>
      <!--<tr>-->
          <!--<th scope="row">1</th>-->
          <!--<td>{{user.userName}}</td>-->
          <!--<td>{{identity.email}}</td>-->
          <!--<td>{{fullAddress.address}}</td>-->
          <!--<td>{{fullAddress.city}}</td>-->
          <!--<td>{{fullAddress.country}}</td>-->
      <!--</tr>-->
       <!--<tr>-->
          <!--<th scope="row">2</th>-->
          <!--<td>{{identity2.userName}}</td>-->
          <!--<td>{{identity2.email}}</td>-->
          <!--<td>{{fullAddress2.address}}</td>-->
          <!--<td>{{fullAddress2.city}}</td>-->
          <!--<td>{{fullAddress2.country}}</td>-->
      <!--</tr>-->
      <!--<tr>-->
          <!--<th scope="row">3</th>-->
          <!--<td>{{identity3.userName}}</td>-->
          <!--<td>{{identity3.email}}</td>-->
          <!--<td>{{fullAddress2.address}}</td>-->
          <!--<td>{{fullAddress2.city}}</td>-->
          <!--<td>{{fullAddress2.country}}</td>-->
      <!--</tr>-->
      <!--<tr>-->
          <!--<th scope="row">4</th>-->
          <!--<td>{{identity4.userName}}</td>-->
          <!--<td>{{identity4.email}}</td>-->
          <!--<td>{{fullAddress4.address}}</td>-->
          <!--<td>{{fullAddress4.city}}</td>-->
          <!--<td>{{fullAddress4.country}}</td>-->
      <!--</tr>-->
      <!--<tr>-->
          <!--<th scope="row">5</th>-->
          <!--<td>{{identity5.userName}}</td>-->
          <!--<td>{{identity5.email}}</td>-->
          <!--<td>{{fullAddress4.address}}</td>-->
          <!--<td>{{fullAddress4.city}}</td>-->
          <!--<td>{{fullAddress4.country}}</td>-->
      <!--</tr>-->
  </tbody>
  
</table>
       
`,

    mounted: function() {
        this.getUsers();
    },
    methods: {
    getUsers(){
        this.get("users.json").then(

            function (response) {
                console.log("success to get all users");
                console.log(response);
                this.allUsers = response.data;
                console.log(this.allUsers);
            },
            function (response) {
                console.log("Error: ", response);
                console.error(response);
            });
    }



    }

});


let vm = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue.js!',
    }
})