<template>
  <v-app>
    <div>
      <v-data-table
        :headers="headers"
        :items="customers"
        :options.sync="options"
        :server-items-length="totalCustomers"
        :loading="loading"
        class="elevation-1"
      >
      <template v-slot:top>
        <v-toolbar
          flat
        >
          <v-toolbar-title>Customers</v-toolbar-title>
          <v-divider
            class="mx-4"
            inset
            vertical
          ></v-divider>
          <v-spacer></v-spacer>
             <v-select
             :items = "countries"
             label="Filter by country"
             @change = "handleCountriesChange"
             ></v-select>
             <v-divider
              class="mx-4"
              inset
              vertical
             ></v-divider>
             <v-select
             :items = "states"
             label = "Filter by state"
             @change = "handleStateChange"
             ></v-select>
        </v-toolbar>
      </template>
      </v-data-table>
    </div>
  </v-app>
</template>

<script>
import axios from 'axios';

export default {
  name: 'App',
  data: () => ({
      totalCustomers: 0,
      customers: [],
      loading: true,
      options: {},
      requestOptions: {
        pageNumber: 0,
        pageSize: 10,
        country: "All",
        state: "All"
      },
      baseUrl:  "http://localhost:8080",
      headers: [
        {
          text: 'Name',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        {
          text: 'Phone',
          align: 'start',
          sortable: false,
          value: 'phone',
        },
        {
          text: 'Country',
          align: 'start',
          sortable: false,
          value: 'country',
        },
        {
          text: 'State',
          align: 'start',
          sortable: false,
          value: 'state',
        },
      ],
      countries: [],
      states: ["All", "Valid", "Not Valid"]
  }),
  watch: {
    options: {
      handler () {
        this.requestOptions.pageNumber = this.options.page;
        this.requestOptions.pageSize = this.options.itemsPerPage;
        this.loadData();
      },
      deep: true
    }
  },
  created () {
    this.loadCountries();
  },
  methods: {
    loadData(){
      this.loading = true;
      axios.post(this.baseUrl + "/customer/getCustomers/", this.requestOptions)
      .then(response => {
        this.customers = response.data.customers;
        this.totalCustomers =  response.data.totalSize;
        this.loading = false;
      })
    },
    loadCountries(){
      this.loading = true;
      axios.get(this.baseUrl + "/country/getCountries/")
      .then(response => {
        this.countries = response.data;
        this.countries.unshift("All");
        this.loading = false;
      })
    },
    handleCountriesChange(value){
      this.requestOptions.country = value;
      this.requestOptions.pageNumber = 1;
      this.loadData();
    },
    handleStateChange(value){
      this.requestOptions.state = value;
      this.requestOptions.pageNumber = 1;
      this.loadData();
    }
  }
}
</script>

<style>
  .v-application--wrap{
    margin: 2%;
  }
</style>