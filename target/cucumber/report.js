$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("VechileVerifications.feature");
formatter.feature({
  "line": 2,
  "name": "Test to validate vechile make and colour",
  "description": "",
  "id": "test-to-validate-vechile-make-and-colour",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@VechicleRegistrationEnquiry"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "Verify vehicle color and make match to expected value in dvla site  from mime type Excel file type",
  "description": "",
  "id": "test-to-validate-vechile-make-and-colour;verify-vehicle-color-and-make-match-to-expected-value-in-dvla-site--from-mime-type-excel-file-type",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I scan the directory to retrieve the supported \"xlsx\" files",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I read vehicle reg numbers from one of the file",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I launch dvla site",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I search for vehicle info by reg number",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should be able match the expected color and make from the given file",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "xlsx",
      "offset": 48
    }
  ],
  "location": "VechileVerifications.i_scan_the_directory_to_retrieve_the_supported_csv_xlsx_files(String)"
});
formatter.result({
  "duration": 688407924,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_read_vehicle_reg_numbers_from_one_of_the_file()"
});
formatter.result({
  "duration": 1040251575,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_launch_dvla_site()"
});
formatter.result({
  "duration": 11498096399,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_search_for_vehicle_info_by_reg_number()"
});
formatter.result({
  "duration": 30734990350,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_should_be_able_match_the_expected_color_and_make_from_the_given_file()"
});
formatter.result({
  "duration": 72296,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Verify vehicle color and make match to expected value in dvla site from mime type CSV file type",
  "description": "",
  "id": "test-to-validate-vechile-make-and-colour;verify-vehicle-color-and-make-match-to-expected-value-in-dvla-site-from-mime-type-csv-file-type",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I scan the directory to retrieve the supported \"csv\" files",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I read vehicle reg numbers from one of the file",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I launch dvla site",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I search for vehicle info by reg number",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I should be able match the expected color and make from the given file",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "csv",
      "offset": 48
    }
  ],
  "location": "VechileVerifications.i_scan_the_directory_to_retrieve_the_supported_csv_xlsx_files(String)"
});
formatter.result({
  "duration": 6664679,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_read_vehicle_reg_numbers_from_one_of_the_file()"
});
formatter.result({
  "duration": 10026252,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_launch_dvla_site()"
});
formatter.result({
  "duration": 3421996203,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_search_for_vehicle_info_by_reg_number()"
});
formatter.result({
  "duration": 29221440748,
  "status": "passed"
});
formatter.match({
  "location": "VechileVerifications.i_should_be_able_match_the_expected_color_and_make_from_the_given_file()"
});
formatter.result({
  "duration": 293925,
  "status": "passed"
});
});