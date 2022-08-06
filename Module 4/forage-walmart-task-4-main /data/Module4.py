# %%
import sqlite3
import glob
import pandas as pd

# %%
file_extension = ".csv"

# %%
all_filenames = [i for i in glob.glob(f"*{file_extension}")]

# %%
print(all_filenames)

# %%
df1 = pd.read_csv('shipping_data_0.csv')
df2 = pd.read_csv('shipping_data_1.csv')
df3 = pd.read_csv('shipping_data_2.csv')

# %%
df1.head()

# %% [markdown]
# 

# %%
df2.head()

# %%
df3.head()

# %%
df_comb23 = pd.merge(df2, df3, how='inner', on = 'shipment_identifier')
print(df_comb23)
df_final = pd.merge(df1, df_comb23, how = 'outer')
df_final

# %%
con = sqlite3.connect('shipment_database.db')
cur = con.cursor()


# %%
# Create tab;e
cur.execute('''CREATE TABLE shipment(origin_warehouse text, destination_store text, product text, on_time boolean, product_qty real, driver_identifier text, shipment_identifier text)''')


# %%
# Insert row of data from dataframe (row by row method)
for row in df_final.itertuples():
    insert_sql = f"INSERT INTO shipment (origin_warehouse, destination_store, product, on_time, product_qty, driver_identifier, shipment_identifier) VALUES ('{row[1]}', '{row[2]}', '{row[3]}', '{row[4]}', '{row[5]}', '{row[6]}', '{row[7]}')"
    cur.execute(insert_sql)
    

# %%
con.commit()


