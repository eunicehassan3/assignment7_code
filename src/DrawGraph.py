import networkx as nx
import matplotlib.pyplot as plt

def draw_graph(arr):
    G = nx.DiGraph()
    n = len(arr)


    # Add vertices
    for vertex, x in arr:
        G.add_node(vertex)

    # Add edges
    for i, (vertex, x) in enumerate(arr):
        right_index = (i + x) % n
        left_index = (i - x) % n
        G.add_edge(arr[i][0], arr[right_index][0])
        G.add_edge(arr[i][0], arr[left_index][0])

    # Draw graph
    pos = nx.circular_layout(G)
    nx.draw(G, pos, with_labels=True, node_size=1000, node_color="lightgreen", font_size=12, font_weight="bold", arrowsize=20)
    plt.title("Directed Graph")
    plt.show()

# Sample Input
input_arr = [('I', 2), ('A', 5), ('E', 4), ('F', 1), ('T', 2), ('S', 3)]
draw_graph(input_arr)