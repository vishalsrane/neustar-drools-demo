insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(1, 6010, 9500000001, 'AVAILABLE');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(2, 6010, 9500000002, 'HOLD FOR LOADING');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(3, 6010, 9500000003, 'RESERVED');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(4, 6010, 9500000004, 'AGING');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(5, 6010, 9500000005, 'ACTIVE');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(6, 6011, 9500000006, 'AVAILABLE');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(7, 6011, 9500000007, 'HOLD FOR LOADING');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(8, 6011, 9500000008, 'RESERVED');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(9, 6011, 9500000009, 'AGING');
insert into directory_number (ID, CURRENT_OCN, DN, RESOURCE_STATE)
    VALUES(10, 6011, 9500000010, 'ACTIVE');



insert into user_data_type(ID, USER_DATA_KEY) values(1, 'UDText');
insert into user_data_type(ID, USER_DATA_KEY) values(2, 'ATT_Test');
insert into user_data_type(ID, USER_DATA_KEY) values(3, 'dn_block');



insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(1, 'Prepaid', 1, 1);
insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(2, 'Yes', 1, 2);
insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(3, 'test-dn-block', 3, 3);
insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(4, 'Prepaid', 3, 1);
insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(5, 'Prepaid', 4, 1);
insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(6, 'No', 4, 2);
insert into user_data(ID, USER_DATA, DIRECTORY_NUMBER_ID, USER_DATA_TYPE_ID)
    VALUES(7, 'test-123-dn-block', 4, 3);