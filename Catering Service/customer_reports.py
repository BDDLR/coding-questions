transactions_1 = [
  ["customer_4", "event_34", "7000"],
  ["customer_4", "event_37", "6000"],
  ["customer_6", "event_15", "3000"],
  ["customer_6", "event_36", "7000"],
  ["customer_6", "event_49", "4000"],
  ["customer_6", "event_67", "6000"],
  ["customer_6", "event_85", "6000"]
]
transactions_2 = [
  ["customer_6", "event_49", "4000"],
  ["customer_6", "event_85", "6000"],
  ["customer_4", "event_34", "7000"],
  ["customer_6", "event_67", "6000"],
  ["customer_6", "event_15", "3000"],
  ["customer_6", "event_36", "7000"],
  ["customer_4", "event_37", "6000"]
]
transactions_3 = [
  ["customer_3", "event_70", "4000"],
  ["customer_3", "event_71", "6900"],
  ["customer_1", "event_40", "1600"],
  ["customer_6", "event_74", "6900"],
  ["customer_8", "event_75", "7400"],
  ["customer_1", "event_43", "6400"],
  ["customer_3", "event_52", "6300"],
  ["customer_6", "event_25", "3500"],
  ["customer_1", "event_62", "2500"]
]

def report_sales(transactions):
    data = {}
    
    for transaction in transactions:
        customer = transaction[0]
        amount = int(transaction[2])
        
        if customer not in data:
            data[customer] = {'events': 0, 'total_spent': 0}
        
        data[customer]['events'] += 1
        data[customer]['total_spent'] += amount

    report = {}
    for customer, data in data.items():
        report[customer] = (data['events'], data['total_spent'])
    
    return report

print(report_sales(transactions_1))
print(report_sales(transactions_2))
print(report_sales(transactions_3))
