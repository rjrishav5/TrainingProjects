import {
  Text,
  TextInput,
  StyleSheet,
  View,
  Button,
  Alert,
  TouchableOpacity,
  FlatList,
} from 'react-native';
import React, {useEffect, useState} from 'react';
import AddContact from './addcontact';
import {openDatabase} from 'react-native-sqlite-storage';

const db = openDatabase({name: 'contactsApp.db'});
import {useIsFocused, useNavigation} from '@react-navigation/native';

const ContactList = () => {
  const [contacts, setContacts] = useState([]);
  const navigation = useNavigation();
  const isFocused = useIsFocused();

  useEffect(() => {
    viewContact();
  }, [isFocused]);

  const viewContact = () => {
    db.transaction(txn => {
      txn.executeSql('SELECT * FROM contacts', [], (tx, res) => {
        const temp = [];
        for (let i = 0; i < res.rows.length; ++i) {
          console.log(res.rows.item(i));
          temp.push(res.rows.item(i));
        }
        setContacts(temp);
      });
    });
  };
  const deleteContact = pnumber => {
    db.transaction(tx => {
      tx.executeSql(
        'DELETE FROM  contacts where pnumber=?',
        [pnumber],
        (tx, results) => {
          console.log('Results', results.rowsAffected);
          if (results.rowsAffected > 0) {
            Alert.alert(
              'Success',
              'Contact deleted successfully',
              [
                {
                  text: 'Ok',
                  onPress: () => {
                    viewContact();
                  },
                },
              ],
              {cancelable: false},
            );
          } else {
            alert('Please insert a valid Contact Id');
          }
        },
      );
    });
  };
  return (
    <View style={styles.container}>
      <View>
        <FlatList
          data={contacts}
          renderItem={({item, index}) => {
            return (
              <TouchableOpacity style={styles.userItem}>
                <Text style={styles.itemText}>{'Name: ' + item.name}</Text>
                <Text style={styles.itemText}>
                  {'Phone Number: ' + item.pnumber}
                </Text>
                <Text style={styles.itemText}>
                  {'Landline : ' + item.lnumber}
                </Text>
                <View style={styles.itemButtons}>
                  <TouchableOpacity style={styles.editButton}>
                    <Text
                      style={styles.buttonText}
                      onPress={() => {
                        navigation.navigate('editcontact', {
                          data: {
                            name: item.name,
                            lnumber: item.lnumber,
                            pnumber: item.pnumber,
                          },
                        });
                      }}>
                      Edit
                    </Text>
                  </TouchableOpacity>
                  <TouchableOpacity style={styles.deleteButton}>
                    <Text
                      style={styles.buttonText}
                      onPress={() => {
                        deleteContact(item.pnumber);
                      }}>
                      Delete
                    </Text>
                  </TouchableOpacity>
                </View>
                <View style={styles.belowView}>
                  {/* <TouchableOpacity
                  onPress={() => {
                    navigation.navigate('EditUser', {
                      data: {
                        name: item.name,
                        email: item.email,
                        address: item.address,
                        id: item.user_id,
                      },
                    });
                  }}>
                  <Image
                    source={require('../images/edit.png')}
                    style={styles.icons}
                  />
                </TouchableOpacity> */}
                  <TouchableOpacity
                    onPress={() => {
                      deleteUser(item.user_id);
                    }}>
                    {/* <Image
                    source={require('../images/delete.png')}
                    style={styles.icons}
                  /> */}
                  </TouchableOpacity>
                </View>
              </TouchableOpacity>
            );
          }}
        />
      </View>
      <TouchableOpacity style={styles.addButton}>
        <Text
          style={styles.addButtonText}
          onPress={() => {
            navigation.navigate('addcontact');
          }}>
          +
        </Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    paddingHorizontal: 16,
    paddingVertical: 24,
  },
  itemButtons: {
    flexDirection: 'row',
    marginTop: 10,
  },
  editButton: {
    backgroundColor: '#3CB371',
    paddingVertical: 5,
    paddingHorizontal: 10,
    marginRight: 10,
    borderRadius: 5,
  },
  deleteButton: {
    backgroundColor: '#FF4500',
    paddingVertical: 5,
    paddingHorizontal: 10,
    borderRadius: 5,
  },
  buttonText: {
    color: '#FFFFFF',
    fontSize: 16,
    fontWeight: 'bold',
  },
  addButton: {
    position: 'absolute',
    bottom: 16,
    right: 16,
    width: 56,
    height: 56,
    borderRadius: 28,
    backgroundColor: '#2196F3',
    alignItems: 'center',
    justifyContent: 'center',
  },
  addButtonText: {
    fontSize: 32,
    color: '#fff',
    fontWeight: 'bold',
  },
  itemText: {
    fontSize: 20,
    fontWeight: '600',
    color: '#000',
  },
  userItem: {
    width: '100%',
    backgroundColor: '#fff',
    padding: 10,
  },
});
export default ContactList;
