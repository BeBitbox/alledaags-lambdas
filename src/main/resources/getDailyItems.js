const AWS = require('aws-sdk');
const documentClient = new AWS.DynamoDB.DocumentClient();

const params = {
    TableName: 'DailyItem',
    KeyConditionExpression: 'dateString = :dateString'
};

function currentDateString() {
    const date_ob = new Date();
    const date = ('0' + date_ob.getDate()).slice(-2);
    const month = ('0' + (date_ob.getMonth() + 1)).slice(-2);
    const year = date_ob.getFullYear();
    return`${year}-${month}-${date}`;
}

exports.handler = async () => {
    const currentDate = currentDateString();
    console.log(`Calling dailyItems for ${currentDate}`);
    params.ExpressionAttributeValues = { ':dateString': currentDate };

    const json = await documentClient.query(params, function(err, data) {
        if (err) {
            console.log('Unable to query. Error: ', JSON.stringify(err, null, 2));
        } else {
            console.log('Query succeeded');
        }
    }).promise();

    return {
        statusCode: 200,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(json['Items'])
    };
};
