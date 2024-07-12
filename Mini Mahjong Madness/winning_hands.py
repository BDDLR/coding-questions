tiles_1 = "88844"
tiles_2 = "99"
tiles_3 = "55555"
tiles_4 = "22333333"
tiles_5 = "73797439949499477339977777997394947947477993"
tiles_6 = "111333555"
tiles_7 = "42"
tiles_8 = "888"
tiles_9 = "100100000"
tiles_10 = "346664366"
tiles_11 = "8999998999898"
tiles_12 = "17610177"
tiles_13 = "600061166"
tiles_14 = "6996999"
tiles_15 = "03799449"
tiles_16 = "64444333355556"
tiles_17 = "7"
tiles_18 = "776655"


def is_valid_count(tile_dict):
    is_valid_pair = False
    for count in tile_dict.values():
        if count != 2 and count != 3:
            return False 
            
        if count == 2 and is_valid_pair == True:
            return False
        
        if count == 2:
            is_valid_pair = True

    return is_valid_pair

def complete(tiles):
    tile_dict = {}
    is_valid_pair = False
    for tile in tiles:
        if not tile in tile_dict:
            tile_dict[tile] =  1
        else:
            current_count = tile_dict.get(tile)
            if current_count == 3:
                current_count = 0
            tile_dict[tile] = current_count + 1
            
    return is_valid_count(tile_dict)
        
    
print(complete(tiles_1))
print(complete(tiles_2))
print(complete(tiles_3))
print(complete(tiles_4))
print(complete(tiles_5))
print(complete(tiles_6))
print(complete(tiles_7))
print(complete(tiles_8))
print(complete(tiles_9))
print(complete(tiles_10))
print(complete(tiles_11))
print(complete(tiles_12))
print(complete(tiles_13))
print(complete(tiles_14))
print(complete(tiles_15))
print(complete(tiles_16))
print(complete(tiles_17))
print(complete(tiles_18))
