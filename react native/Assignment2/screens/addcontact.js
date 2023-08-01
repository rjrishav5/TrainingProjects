import {
  Text,
  TextInput,
  StyleSheet,
  View,
  Button,
  Alert,
  ScrollView,
  TouchableOpacity,
} from 'react-native';
import {useNavigation} from '@react-navigation/native';
import React, {useEffect, useState} from 'react';
import {openDatabase} from 'react-native-sqlite-storage';

const db = openDatabase({name: 'contactsApp.db'});

const AddContact = () => {
  const [name, setName] = useState('');
  const [pnumber, setPnumber] = useState(0);
  const [lnumber, setLnumber] = useState(0);
  const [favorite, setfavorite] = useState(false);

  const navigation = useNavigation();
  useEffect(() => {
    db.transaction(txn => {
      txn.executeSql(
        "SELECT name FROM sqlite_master WHERE type='table' AND name='contacts'",
        [],
        (tx, res) => {
          console.log('item:', res.rows.length);
          if (res.rows.length == 0) {
            txn.executeSql('DROP TABLE IF EXISTS contacts', []);
            txn.executeSql(
              'CREATE TABLE IF NOT EXISTS contacts(pnumber INT(10) PRIMARY KEY , name VARCHAR(20), lnumber INT(10))',
              [],
            );
          }
        },
        error => {
          console.log(error);
        },
      );
    });
  }, []);

  const saveContact = () => {
    console.log(name, pnumber, lnumber);

    db.transaction(function (tx) {
      tx.executeSql(
        'INSERT INTO contacts(pnumber,name,lnumber) VALUES (?,?,?)',
        [pnumber, name, lnumber],
        (txn, res) => {
          console.log('res', res.rowsAffected > 0);
          if (res.rowsAffeted > 0) {
            Alert.alert('Success', 'Your contact added', [
              {
                text: 'Ok',
                onPress: () => navigation.navigate('contactlist'),
              },
            ]);
          } else alert('failed!');
        },
        error => {
          console.log(error);
        },
      );
    });
  };
  return (
    <View style={styles.constainer}>
      <View style={{flex: 1, marginHorizontal: 10}}>
        <ScrollView style={styles.sview}>
          <TextInput
            style={styles.inputstyle}
            placeholder="Name"
            onChangeText={text => setName(text)}
          />
          <TextInput
            keyboardType="number-pad"
            style={styles.inputstyle}
            placeholder="Phone Number"
            maxLength={10}
            onChangeText={text => setPnumber(text)}
          />
          <TextInput
            keyboardType="number-pad"
            style={styles.inputstyle}
            placeholder="Land Line number"
            maxLength={12}
            onChangeText={text => setLnumber(text)}
          />
          <View style={{flex: 3, flexDirection: 'row', marginBottom: 20}}>
            <Text>Favorite </Text>
            {/* <Checkbox
              style={{alignSelf: 'center'}}
              status={'unchecked'}
              uncheckedColor="black"
              onPress={() => {
                setfavorite(true);
              }}
            /> */}
          </View>
          <TouchableOpacity
            style={styles.addBtn}
            onPress={() => {
              saveContact();
            }}>
            <Text style={styles.btnText}>Save Contact</Text>
          </TouchableOpacity>
        </ScrollView>
      </View>
    </View>
  );
};
const styles = StyleSheet.create({
  constainer: {
    flex: 1,
    marginBottom: 10,
    backgroundColor: 'pink',
  },
  inputstyle: {
    borderColor: 'black',
    borderWidth: 1,
    paddingHorizontal: 1,
    paddingVertical: 20,
    borderRadius: 5,
    marginBottom: 15,
    marginVertical: 10,
  },
  sview: {
    flex: 1,
    marginHorizontal: 15,
  },
  addBtn: {
    backgroundColor: 'purple',
    width: '80%',
    height: 50,
    borderRadius: 10,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 30,
    alignSelf: 'center',
  },
});
export default AddContact;
