import networkx as nx
import matplotlib.pyplot as plt

def create_directed_graph(array):
    n = len(array)
    G = nx.DiGraph()

    for i, vertex in enumerate(array):
        left_neighbor = array[(i - vertex) % n]
        right_neighbor = array[(i + vertex) % n]
        G.add_edge(chr(65 + i), chr(65 + (i - vertex) % n))
        G.add_edge(chr(65 + i), chr(65 + (i + vertex) % n))

    return G

def draw_graph(G):
    pos = nx.spring_layout(G)
    nx.draw(G, pos, with_labels=True, node_size=2000, node_color="skyblue", font_size=20, font_weight="bold", arrowsize=20)
    plt.show()

if __name__ == "__main__":
    array = [2, 3, 1, 4]  # Example array, you can replace it with any array of your choice
    G = create_directed_graph(array)
    draw_graph(G)